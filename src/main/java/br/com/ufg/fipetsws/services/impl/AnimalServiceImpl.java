package br.com.ufg.fipetsws.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufg.fipetsws.entities.Animal;
import br.com.ufg.fipetsws.repositories.AnimalRepository;
import br.com.ufg.fipetsws.services.AnimalService;

@Service
public class AnimalServiceImpl implements AnimalService{

	@Autowired
	private AnimalRepository animalRepository;
	
	@Override
	public Optional<Animal> findById(String id) {
		return this.animalRepository.findById(id);
	}

	@Override
	public Animal createOrUpdate(Animal animal) {
		return this.animalRepository.save(animal);
	}

	@Override
	public List<Animal> findAll() {
		return this.animalRepository.findAll();
	}

}	
