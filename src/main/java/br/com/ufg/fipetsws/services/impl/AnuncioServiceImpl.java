package br.com.ufg.fipetsws.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

	@Override
	public Page<Anuncio> listAnuncio(int page, int count) {
		return this.anuncioRepository.findAll(PageRequest.of(page, count));
	}

	@Override
	public Page<Anuncio> listAnuncioRaio(int page, int count, Double latitude, Double longitude) {
//		return this.anuncioRepository.findAnuncioRaio(PageRequest.of(page, count), latitude, longitude);
		return null;
	}

}	
