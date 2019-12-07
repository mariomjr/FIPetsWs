package br.com.ufg.fipetsws.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.ufg.fipetsws.entities.Raca;
import br.com.ufg.fipetsws.enums.EnumTipoAnimal;

@Component
public interface RacaService {

	Raca createOrUpdate(Raca raca);
	
	Optional<Raca> findById(String id);
	
	List<Raca> findAll();
	
	List<Raca> findByTipo(EnumTipoAnimal tipo);
}
