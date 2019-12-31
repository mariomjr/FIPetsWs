package br.com.ufg.fipetsws.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.ufg.fipetsws.entities.Usuario;

public interface UsuarioRepository  extends MongoRepository<Usuario, String>{

	
	Optional<Usuario> findByEmail(String email);
	
}
