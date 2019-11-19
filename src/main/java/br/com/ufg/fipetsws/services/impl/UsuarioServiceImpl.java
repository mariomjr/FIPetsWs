package br.com.ufg.fipetsws.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufg.fipetsws.entities.Usuario;
import br.com.ufg.fipetsws.repositories.UsuarioRepository;
import br.com.ufg.fipetsws.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario createOrUpdate(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}

	@Override
	public Optional<Usuario> findById(String id) {
		return this.usuarioRepository.findById(id);
	}

	@Override
	public List<Usuario> findAll() {
		return this.usuarioRepository.findAll();
	}

}
