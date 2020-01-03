package br.com.ufg.fipetsws.controllers;

import br.com.ufg.fipetsws.dto.UsuarioTokenDto;
import br.com.ufg.fipetsws.entities.Usuario;
import br.com.ufg.fipetsws.mappers.UsuarioMapper;
import br.com.ufg.fipetsws.response.Response;
import br.com.ufg.fipetsws.security.firebase.LoginResponse;
import br.com.ufg.fipetsws.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ufg.fipetsws.security.firebase.AuthRequest;
import br.com.ufg.fipetsws.services.AuthFirebaseService;

import java.util.Optional;

@RestController
@CrossOrigin(origins="*")
public class AuthenticationRestController {

	@Autowired
	private AuthFirebaseService authFirebaseService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
//	
//	@Autowired
//	private JwtTokenUtil jwtTokenUtil;
//	
//	@Autowired
//	private UserDetailsService userDetailsService;
//	
	@Autowired
	UsuarioService usuarioService;

	@PostMapping(value="/api/auth")
	public ResponseEntity<Response<UsuarioTokenDto>> createAuthenticationToken(@RequestBody AuthRequest authRequest) throws Exception{
		Response<UsuarioTokenDto> response = new Response<UsuarioTokenDto>();
		try {
			Optional<Usuario> usuario = usuarioService.findByEmail(authRequest.getEmail());
			LoginResponse loginAuth = authFirebaseService.autenticar(authRequest);
			UsuarioTokenDto usuarioTokenDto = UsuarioMapper.INSTANCE.paraTokenDto(usuario.get());
			usuarioTokenDto.setIdToken(loginAuth.getIdToken());
			response.setData(usuarioTokenDto);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.getErrors().add(e.getMessage());
			return ResponseEntity.ok(response);
		}
	}

}
