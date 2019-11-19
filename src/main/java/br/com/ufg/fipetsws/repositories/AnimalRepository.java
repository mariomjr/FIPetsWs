package br.com.ufg.fipetsws.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.ufg.fipetsws.entities.Animal;

public interface AnimalRepository  extends MongoRepository<Animal, String>{

}
