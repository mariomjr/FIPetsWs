package br.com.ufg.fipetsws.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.ufg.fipetsws.entities.Usuario;

@Component
public interface UsuarioService {

	Usuario createOrUpdate(Usuario usuario);
	
	Optional<Usuario> findById(String id);
	
	List<Usuario> findAll();
}
