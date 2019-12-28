package br.com.ufg.fipetsws.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.ufg.fipetsws.entities.Raca;
import br.com.ufg.fipetsws.enums.EnumTipoAnimal;

public interface RacaRepository  extends MongoRepository<Raca, String>{

	List<Raca> findByTipo(EnumTipoAnimal tipo);
	
	Optional<Raca> findByNomeRaca(String nomeRaca);
}
