package br.com.ufg.fipetsws.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.ufg.fipetsws.entities.Usuario;
import br.com.ufg.fipetsws.security.jwt.JwtUser;
import br.com.ufg.fipetsws.services.UsuarioService;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UsuarioService userService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Usuario> usuario = userService.findByEmail(email);
		if(usuario.isPresent() == false) {
			throw new UsernameNotFoundException(String.format("Usuário não encontrado '%s'.", email));
		}else {
			return new JwtUser(usuario.get().getId(), usuario.get().getEmail(), null);
		}
	}

}
