package br.com.ufg.fipetsws.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.ufg.fipetsws.entities.Anuncio;

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
//	Page<Anuncio> findAnuncioRaio(Pageable page, @Param("latitude") Double latitude,  @Param("longitude")Double longitude);
	
}
