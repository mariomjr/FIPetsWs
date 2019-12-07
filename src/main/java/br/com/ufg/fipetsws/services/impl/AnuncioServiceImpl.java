package br.com.ufg.fipetsws.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufg.fipetsws.entities.Anuncio;
import br.com.ufg.fipetsws.repositories.AnuncioRepository;
import br.com.ufg.fipetsws.services.AnuncioService;

@Service
public class AnuncioServiceImpl implements AnuncioService{

	@Autowired
	private AnuncioRepository anuncioRepository;
	
	@Override
	public Optional<Anuncio> findById(String id) {
		return this.anuncioRepository.findById(id);
	}

	@Override
	public Anuncio createOrUpdate(Anuncio anucio) {
		return this.anuncioRepository.save(anucio);
	}

	@Override
	public List<Anuncio> findAll() {
		return this.anuncioRepository.findAll();
	}

}	