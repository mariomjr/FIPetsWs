package br.com.ufg.fipetsws.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.ufg.fipetsws.entities.Raca;

public interface RacaRepository  extends MongoRepository<Raca, String>{

}
