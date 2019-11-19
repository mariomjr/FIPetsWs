package br.com.ufg.fipetsws.controllers;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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
import br.com.ufg.fipetsws.entities.Animal;
import br.com.ufg.fipetsws.entities.Anuncio;
import br.com.ufg.fipetsws.mappers.AnuncioMapper;
import br.com.ufg.fipetsws.response.Response;
import br.com.ufg.fipetsws.services.AnimalService;
import br.com.ufg.fipetsws.services.AnuncioService;
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

	@PostMapping
	@ApiOperation("Criação de anúncio")
	public ResponseEntity<Response<AnuncioDto>> create(HttpServletRequest request, @RequestBody AnuncioCreateDto anuncio,
			BindingResult result){
		Response<AnuncioDto> response = new Response<AnuncioDto>();
		Anuncio anuncioCreate = AnuncioMapper.INSTANCE.doCreateDto(anuncio);
		anuncioCreate.getAnimal().setDataCriacao(Calendar.getInstance().getTimeInMillis());
		Animal animal = animalService.createOrUpdate(anuncioCreate.getAnimal());
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
	
	@GetMapping
	@ApiOperation("Listar anuncios")
	public ResponseEntity<Response<List<AnuncioDto>>> get(){
		Response<List<AnuncioDto>> response = new Response<List<AnuncioDto>>();
		List<Anuncio> listAnucio = anuncioService.findAll();
		if(listAnucio.isEmpty()) {
			response.getErrors().add("Nenhum anúncio cadastrado!");
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(AnuncioMapper.INSTANCE.paraDto(listAnucio));
		return ResponseEntity.ok(response);
	}
}
