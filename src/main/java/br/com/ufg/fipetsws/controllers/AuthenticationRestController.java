package br.com.ufg.fipetsws.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ufg.fipetsws.security.firebase.AuthRequest;
import br.com.ufg.fipetsws.services.AuthFirebaseService;

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
//	@Autowired
//	private UsuarioService userService;
//	
	@PostMapping(value="/api/auth")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest authRequest) throws Exception{
		
//		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
//		final String token = jwtTokenUtil.generateToken(userDetails);
//		final User user = userService.findByEmail(authenticationRequest.getEmail());
//		user.setPassword(null);
		try {
//			final Authentication authentication = authenticationManager.authenticate(
//					new UsernamePasswordAuthenticationToken(
//							authRequest.getEmail(), 
//							authRequesfinal Authentication authentication = authenticationManager.authenticate(
//					new UsernamePasswordAuthenticationToken(
//							authRequest.getEmail(), 
//							authRequest.getPassword()
//					)
//			);
//			SecurityCt.getPassword()
//					)
//			);
//			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			return ResponseEntity.ok(authFirebaseService.autenticar(authRequest));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
//	
//	@PostMapping(value="/api/refresh")
//	public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request){
//		String token = request.getHeader("Authorization");
//		String username = jwtTokenUtil.gertUsernameFromToken(token);
//		
//		Optional<Usuario> user = userService.findByEmail(username);
//		
//		if(jwtTokenUtil.canTokenBeRefresehd(token)) {
//			String refreshedToken = jwtTokenUtil.refreshToken(token);
//			return ResponseEntity.ok(new CurrentUser(refreshedToken, user));
//		}else {
//			return ResponseEntity.badRequest().body(null);
//		}
//	}
}
