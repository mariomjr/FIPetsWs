package br.com.ufg.fipetsws.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.ufg.fipetsws.entities.Anuncio;

@Component
public interface AnuncioService {

	Anuncio createOrUpdate(Anuncio anuncio);
	
	Optional<Anuncio> findById(String id);
	
	List<Anuncio> findAll();
	
	Page<Anuncio> listAnuncio(int page, int count);
	
	Page<Anuncio> listAnuncioRaio(int page, int count, Double latitude, Double longitude);
}
