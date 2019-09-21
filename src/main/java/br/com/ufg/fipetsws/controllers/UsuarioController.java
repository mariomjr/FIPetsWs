package br.com.ufg.fipetsws.controllers;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ufg.fipetsws.dto.UsuarioCreateDto;
import br.com.ufg.fipetsws.dto.UsuarioDto;
import br.com.ufg.fipetsws.entities.Usuario;
import br.com.ufg.fipetsws.mappers.UsuarioMapper;
import br.com.ufg.fipetsws.response.Response;
import br.com.ufg.fipetsws.services.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/usuario")
@Api("Usuário")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;

	@PostMapping
	@ApiOperation("Criação do usuário")
	public ResponseEntity<Response<UsuarioDto>> create(HttpServletRequest request, @RequestBody UsuarioCreateDto usuario,
			BindingResult result){
		Response<UsuarioDto> response = new Response<UsuarioDto>();
		Usuario usuarioCreate = usuarioService.createOrUpdate(UsuarioMapper.INSTANCE.doCreateDto(usuario));
		response.setData(UsuarioMapper.INSTANCE.paraDto(usuarioCreate));
		return ResponseEntity.ok(response);
	}
	
	@PutMapping
	@ApiOperation("Update do usuário")
	public ResponseEntity<Response<UsuarioDto>> update(HttpServletRequest request, @RequestBody UsuarioDto usuarioDto,
			BindingResult result){
		Response<UsuarioDto> response = new Response<UsuarioDto>();
		Optional<Usuario> usuario = usuarioService.findById(usuarioDto.getId());
		if(usuario.isPresent()) {
			UsuarioMapper.INSTANCE.atualizar(usuarioDto,usuario.get());
			usuarioService.createOrUpdate(usuario.get());
			response.setData(UsuarioMapper.INSTANCE.paraDto(usuario.get()));
		}
		return ResponseEntity.ok(response);
	}
}
