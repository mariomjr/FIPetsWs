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
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.geo.Sphere;
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
		anucio.setLocation(new GeoJsonPoint(new Point(anucio.getLatitude(), anucio.getLongitude())));
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
		return this.anuncioRepository.findByLocationWithin(PageRequest.of(page, count), new Sphere(circle));
	}

}
