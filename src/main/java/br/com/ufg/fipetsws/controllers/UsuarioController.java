package br.com.ufg.fipetsws.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import br.com.ufg.fipetsws.dto.UsuarioTokenDto;
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

import br.com.ufg.fipetsws.dto.UsuarioCreateDto;
import br.com.ufg.fipetsws.dto.UsuarioDto;
import br.com.ufg.fipetsws.entities.Usuario;
import br.com.ufg.fipetsws.mappers.UsuarioMapper;
import br.com.ufg.fipetsws.response.Response;
import br.com.ufg.fipetsws.security.firebase.AuthRequest;
import br.com.ufg.fipetsws.security.firebase.LoginResponse;
import br.com.ufg.fipetsws.services.AuthFirebaseService;
import br.com.ufg.fipetsws.services.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController(value="Usuário")
@RequestMapping("/usuario")
@Api("Usuário")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	AuthFirebaseService authFirebaseService;

	@PostMapping
	@ApiOperation("Criação do usuário")
	public ResponseEntity<Response<UsuarioTokenDto>> create(HttpServletRequest request, @RequestBody UsuarioCreateDto usuario,
															BindingResult result){
		Response<UsuarioTokenDto> response = new Response<UsuarioTokenDto>();
		try {
			LoginResponse loginResponse = authFirebaseService.criarUsuario(new AuthRequest(usuario.getEmail(), usuario.getPassword()));
			Usuario usuarioCre = UsuarioMapper.INSTANCE.doCreateDto(usuario);
			usuarioCre.setUidFirebase(loginResponse.getLocalId());
			Usuario usuarioCreate = usuarioService.createOrUpdate(usuarioCre);
			UsuarioTokenDto usuarioTokenDto = UsuarioMapper.INSTANCE.paraTokenDto(usuarioCreate);
			usuarioTokenDto.setIdToken(loginResponse.getIdToken());
			response.setData(usuarioTokenDto);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.getErrors().add(e.getMessage());
			return ResponseEntity.ok(response);
		}
		
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
	
	@GetMapping(value="{id}")
	@ApiOperation("Buscar por ID")
	public ResponseEntity<Response<UsuarioDto>> findById(@PathVariable("id") String id){
		Response<UsuarioDto> response = new Response<UsuarioDto>();
		Optional<Usuario> usuario = usuarioService.findById(id);
		if(usuario.isPresent() == false) {
			response.getErrors().add("Registro não encontrado!");
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(UsuarioMapper.INSTANCE.paraDto(usuario.get()));
		return ResponseEntity.ok(response);
	}
	
	@GetMapping
	@ApiOperation("Listar usuários")
	public ResponseEntity<Response<List<UsuarioDto>>> get(){
		Response<List<UsuarioDto>> response = new Response<List<UsuarioDto>>();
		List<Usuario> listUsuario = usuarioService.findAll();
		if(listUsuario.isEmpty()) {
			response.getErrors().add("Nenhuma raça cadastrada");
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(UsuarioMapper.INSTANCE.paraDto(listUsuario));
		return ResponseEntity.ok(response);
	}
}
