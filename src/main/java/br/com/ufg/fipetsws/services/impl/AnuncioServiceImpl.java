package br.com.ufg.fipetsws.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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
		anucio.setPoint(new Point(anucio.getLatitude(), anucio.getLongitude()));
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
		Point point = new Point(latitude, longitude);
		Distance distance = new Distance(2, Metrics.KILOMETERS);
		Circle circle = new Circle(point, distance);
		Criteria geoCriteria = Criteria.where("position").withinSphere(circle);
		Query query = Query.query(geoCriteria);
//		this.anuncioRepository.
//		return this.anuncioRepository.findAnuncioRaio(PageRequest.of(page, count), latitude, longitude);
		return null;
	}

}	
