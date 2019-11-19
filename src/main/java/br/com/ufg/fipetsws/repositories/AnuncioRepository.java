package br.com.ufg.fipetsws.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.ufg.fipetsws.entities.Anuncio;

public interface AnuncioRepository  extends MongoRepository<Anuncio, String>{

}
