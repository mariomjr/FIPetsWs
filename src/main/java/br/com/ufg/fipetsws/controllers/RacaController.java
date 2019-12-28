package br.com.ufg.fipetsws.controllers;

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

import br.com.ufg.fipetsws.dto.RacaCreateDto;
import br.com.ufg.fipetsws.dto.RacaDto;
import br.com.ufg.fipetsws.entities.Raca;
import br.com.ufg.fipetsws.enums.EnumTipoAnimal;
import br.com.ufg.fipetsws.mappers.RacaMapper;
import br.com.ufg.fipetsws.response.Response;
import br.com.ufg.fipetsws.services.RacaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController(value="Raça")
@RequestMapping("/raca")
@Api("Raça")
public class RacaController {
	
	@Autowired
	RacaService racaService;

	@PostMapping
	@ApiOperation("Criação de raças")
	public ResponseEntity<Response<RacaDto>> create(HttpServletRequest request, @RequestBody RacaCreateDto raca,
			BindingResult result){
		Response<RacaDto> response = new Response<RacaDto>();
		Raca racaCreate = racaService.createOrUpdate(RacaMapper.INSTANCE.doCreateDto(raca));
		response.setData(RacaMapper.INSTANCE.paraDto(racaCreate));
		return ResponseEntity.ok(response);
	}
	
	/*@PostMapping(value="list/{tipo}")
	@ApiOperation("Criação de raças")
	public ResponseEntity<String> createList(HttpServletRequest request, @RequestBody List<String> listStrRaca, @PathVariable("tipo") EnumTipoAnimal tipo,
			BindingResult result){
		for (String racaStr : listStrRaca) {
			if(racaService.findByNomeRaca(racaStr).isPresent() == false) {
				Raca raca = new Raca();
				raca.setNomeRaca(racaStr);
				raca.setTipo(tipo);
				racaService.createOrUpdate(raca);
			}
		}
		return ResponseEntity.ok("Ok");
	}*/
	
	@PutMapping
	@ApiOperation("Update na raça")
	public ResponseEntity<Response<RacaDto>> update(HttpServletRequest request, @RequestBody RacaDto usuarioDto,
			BindingResult result){
		Response<RacaDto> response = new Response<RacaDto>();
		Optional<Raca> raca = racaService.findById(usuarioDto.getId());
		if(raca.isPresent()) {
			RacaMapper.INSTANCE.atualizar(usuarioDto,raca.get());
			racaService.createOrUpdate(raca.get());
			response.setData(RacaMapper.INSTANCE.paraDto(raca.get()));
		}
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value="{id}")
	@ApiOperation("Buscar por ID")
	public ResponseEntity<Response<RacaDto>> findById(@PathVariable("id") String id){
		Response<RacaDto> response = new Response<RacaDto>();
		Optional<Raca> raca = racaService.findById(id);
		if(raca.isPresent() == false) {
			response.getErrors().add("Registro não encontrado!");
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(RacaMapper.INSTANCE.paraDto(raca.get()));
		return ResponseEntity.ok(response);
	}
	
	@GetMapping
	@ApiOperation("Listar raças")
	public ResponseEntity<Response<List<RacaDto>>> get(){
		Response<List<RacaDto>> response = new Response<List<RacaDto>>();
		List<Raca> listRaca = racaService.findAll();
		if(listRaca.isEmpty()) {
			response.getErrors().add("Nenhuma raça cadastrada");
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(RacaMapper.INSTANCE.paraDto(listRaca));
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value="tipo/{tipo}")
	@ApiOperation("Listar raças por tipo")
	public ResponseEntity<Response<List<RacaDto>>> get(@PathVariable("tipo") EnumTipoAnimal tipoAnimal){
		Response<List<RacaDto>> response = new Response<List<RacaDto>>();
		List<Raca> listRaca = racaService.findByTipo(tipoAnimal);
		if(listRaca.isEmpty()) {
			response.getErrors().add("Nenhuma raça cadastrada");
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(RacaMapper.INSTANCE.paraDto(listRaca));
		return ResponseEntity.ok(response);
	}
}
