package br.com.ufg.fipetsws.controllers;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ufg.fipetsws.dto.AnuncioCreateDto;
import br.com.ufg.fipetsws.dto.AnuncioDto;
import br.com.ufg.fipetsws.dto.RaioConsultaDto;
import br.com.ufg.fipetsws.entities.Animal;
import br.com.ufg.fipetsws.entities.Anuncio;
import br.com.ufg.fipetsws.entities.Usuario;
import br.com.ufg.fipetsws.mappers.AnuncioMapper;
import br.com.ufg.fipetsws.response.Response;
import br.com.ufg.fipetsws.services.AnimalService;
import br.com.ufg.fipetsws.services.AnuncioService;
import br.com.ufg.fipetsws.services.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController(value="Anúncio")
@RequestMapping("/anuncio")
@Api("Anúncio")
public class AnuncioController {
	
	@Autowired
	AnuncioService anuncioService;
	
	@Autowired
	AnimalService animalService;
	
	@Autowired
	UsuarioService usuarioService;

	@PostMapping
	@ApiOperation("Criação de anúncio")
	public ResponseEntity<Response<AnuncioDto>> create(HttpServletRequest request, @RequestBody AnuncioCreateDto anuncio,
			BindingResult result){
		Response<AnuncioDto> response = new Response<AnuncioDto>();
		Anuncio anuncioCreate = AnuncioMapper.INSTANCE.doCreateDto(anuncio);
		anuncioCreate.getAnimal().setDataCriacao(Calendar.getInstance().getTimeInMillis());
		Animal animal = animalService.createOrUpdate(anuncioCreate.getAnimal());
		Optional<Usuario> usuario = usuarioService.findById(animal.getUsuario().getId());
		Optional<Usuario> usuarioAnuncio = usuarioService.findById(anuncioCreate.getUsuario().getId());
		animal.setUsuario(usuario.get());
		anuncioCreate.setUsuario(usuarioAnuncio.get());
		anuncioCreate.setAnimal(animal);
		anuncioCreate.setDataCriacao(Calendar.getInstance().getTimeInMillis());
		anuncioCreate = anuncioService.createOrUpdate(anuncioCreate);
		response.setData(AnuncioMapper.INSTANCE.paraDto(anuncioCreate));
		return ResponseEntity.ok(response);
	}
	
	@PutMapping
	@ApiOperation("Update no anuncio")
	public ResponseEntity<Response<AnuncioDto>> update(HttpServletRequest request, @RequestBody AnuncioDto anuncioDto,
			BindingResult result){
		Response<AnuncioDto> response = new Response<AnuncioDto>();
		Optional<Anuncio> anuncio = anuncioService.findById(anuncioDto.getId());
		if(anuncio.isPresent()) {
			AnuncioMapper.INSTANCE.atualizar(anuncioDto,anuncio.get());
			anuncio.get().setDataAtualizacao(Calendar.getInstance().getTimeInMillis());
			anuncioService.createOrUpdate(anuncio.get());
			response.setData(AnuncioMapper.INSTANCE.paraDto(anuncio.get()));
		}
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value="{id}")
	@ApiOperation("Buscar por ID")
	public ResponseEntity<Response<AnuncioDto>> findById(@PathVariable("id") String id){
		Response<AnuncioDto> response = new Response<AnuncioDto>();
		Optional<Anuncio> anuncio = anuncioService.findById(id);
		if(anuncio.isPresent() == false) {
			response.getErrors().add("Registro não encontrado!");
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(AnuncioMapper.INSTANCE.paraDto(anuncio.get()));
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value ="{page}/{count}")
	@ApiOperation("Listar anuncios")
	public ResponseEntity<Response<List<AnuncioDto>>> get(HttpServletRequest request, @PathVariable("page") int page, @PathVariable("count") int count){
		Response<List<AnuncioDto>> response = new Response<List<AnuncioDto>>();
		Page<Anuncio> listAnucio = anuncioService.listAnuncio(page, count);
		if(listAnucio.isEmpty()) {
			response.getErrors().add("Nenhum anúncio cadastrado!");
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(AnuncioMapper.INSTANCE.paraDto(listAnucio.getContent()));
		return ResponseEntity.ok(response);
	}
	
	@PostMapping(value ="raio/{page}/{count}")
	@ApiOperation("Listar anuncios no raio")
	public ResponseEntity<Response<List<AnuncioDto>>> getAnuncioRaio(@PathVariable("page") int page, 
			@PathVariable("count") int count,
			@RequestBody RaioConsultaDto raioConsulta){
		Response<List<AnuncioDto>> response = new Response<List<AnuncioDto>>();
		Page<Anuncio> listAnucio = anuncioService.listAnuncioRaio(page, count, raioConsulta.getLatitude(), raioConsulta.getLongitude());
		if(listAnucio.isEmpty()) {
			response.getErrors().add("Nenhum anúncio cadastrado!");
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(AnuncioMapper.INSTANCE.paraDto(listAnucio.getContent()));
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("seguir/{idUsuario}/{idAnuncio}")
	@ApiOperation("Seguir anuncio")
	public ResponseEntity<Response<String>> seguir(
			@PathVariable("idUsuario") String idUsuario, @PathVariable("idAnuncio")String idAnucio){
		Response<String> response = new Response<String>();
		Optional<Anuncio> anuncio = anuncioService.findById(idAnucio);
		if(anuncio.isPresent() == false) {
			response.getErrors().add("Anúncio não encontrado!");
			return ResponseEntity.badRequest().body(response);
		}
		Optional<Usuario> usuario = usuarioService.findById(idUsuario);
		if(usuario.isPresent() == false) {
			response.getErrors().add("Usuário não encontrado!");
			return ResponseEntity.badRequest().body(response);
		}
		if(usuario.get().getListAnuncioSeguidos().contains(anuncio.get()) == false) {
			usuario.get().getListAnuncioSeguidos().add(anuncio.get());
			usuarioService.createOrUpdate(usuario.get());
		}
		response.setData("Seguindo");
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("desseguir/{idUsuario}/{idAnuncio}")
	@ApiOperation("Desseguir anuncio")
	public ResponseEntity<Response<String>> desseguir(
			@PathVariable("idUsuario") String idUsuario, @PathVariable("idAnuncio")String idAnucio){
		Response<String> response = new Response<String>();
		Optional<Anuncio> anuncio = anuncioService.findById(idAnucio);
		if(anuncio.isPresent() == false) {
			response.getErrors().add("Anúncio não encontrado!");
			return ResponseEntity.badRequest().body(response);
		}
		Optional<Usuario> usuario = usuarioService.findById(idUsuario);
		if(usuario.isPresent() == false) {
			response.getErrors().add("Usuário não encontrado!");
			return ResponseEntity.badRequest().body(response);
		}
		if(usuario.get().getListAnuncioSeguidos().contains(anuncio.get())) {
			usuario.get().getListAnuncioSeguidos().remove(anuncio.get());
			usuarioService.createOrUpdate(usuario.get());
		}
		response.setData("Seguindo");
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value ="/usuario/{idUsuario}")
	@ApiOperation("Listar anuncios do usuario")
	public ResponseEntity<Response<List<AnuncioDto>>> get(HttpServletRequest request, @PathVariable("idUsuario") String idUsuario){
		Response<List<AnuncioDto>> response = new Response<List<AnuncioDto>>();
		Optional<Usuario> usuario = usuarioService.findById(idUsuario);
		if(usuario.isPresent() == false) {
			response.getErrors().add("Usuário não encontrado!");
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(AnuncioMapper.INSTANCE.paraDto(usuario.get().getListAnuncioSeguidos()));
		return ResponseEntity.ok(response);
	}
	
}
