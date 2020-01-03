package br.com.ufg.fipetsws.repositories;

import com.mongodb.client.model.geojson.Polygon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.geo.Sphere;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.ufg.fipetsws.entities.Anuncio;

import java.util.List;

public interface AnuncioRepository  extends MongoRepository<Anuncio, String>{
	
//	static String SQL_RAIO_ANUNCIO = "SELECT a FROM Anuncio a " + 
//			"WHERE (" + 
//			"          acos(sin(a.latitude * 0.0175) * sin(:latitude * 0.0175) " + 
//			"               + cos(a.latitude * 0.0175) * cos(:latitude * 0.0175) *    " + 
//			"                 cos((:longitude * 0.0175) - (a.longitude * 0.0175)) " + 
//			"              ) * 3959" + 
//			"      )";
//
//	@Query(value = SQL_RAIO_ANUNCIO)
//	default List<Anuncio> findAnuncioRaio(Double latitude,  Double longitude){
//		Point point = new Point(latitude, longitude);
//		Distance distance = new Distance(2, Metrics.KILOMETERS);
//		Circle circle = new Circle(point, distance);
//		Criteria geoCriteria = Criteria.where("position").withinSphere(circle);
//		Query query = Query.query(geoCriteria);
//		
//	}

    Page<Anuncio> findByLocationWithin(Pageable pageable, Sphere sphere);

    List<Anuncio> findByUsuarioId(String id);
	
}
