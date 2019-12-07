package br.com.ufg.fipetsws.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufg.fipetsws.entities.Raca;
import br.com.ufg.fipetsws.enums.EnumTipoAnimal;
import br.com.ufg.fipetsws.repositories.RacaRepository;
import br.com.ufg.fipetsws.services.RacaService;

@Service
public class RacaServiceImpl implements RacaService{

	@Autowired
	private RacaRepository racaRepository;
	
	@Override
	public Optional<Raca> findById(String id) {
		return this.racaRepository.findById(id);
	}

	@Override
	public Raca createOrUpdate(Raca raca) {
		return this.racaRepository.save(raca);
	}

	@Override
	public List<Raca> findAll() {
		return this.racaRepository.findAll();
	}

	@Override
	public List<Raca> findByTipo(EnumTipoAnimal tipo) {
		return this.racaRepository.findByTipo(tipo);
	}

}
