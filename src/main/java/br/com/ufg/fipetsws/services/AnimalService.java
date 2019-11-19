package br.com.ufg.fipetsws.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.ufg.fipetsws.entities.Animal;

@Component
public interface AnimalService {

	Animal createOrUpdate(Animal anuncio);
	
	Optional<Animal> findById(String id);
	
	List<Animal> findAll();
}
