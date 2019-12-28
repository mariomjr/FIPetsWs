package br.com.ufg.fipetsws.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.ufg.fipetsws.entities.Anuncio;

public interface AnuncioRepository  extends MongoRepository<Anuncio, String>{
	
//	static String SQL_RAIO_ANUNCIO = "SELECT a FROM Anuncio a \r\n" + 
//			"WHERE (\r\n" + 
//			"          acos(sin(a.Latitude * 0.0175) * sin(:latitude * 0.0175) \r\n" + 
//			"               + cos(a.Latitude * 0.0175) * cos(:latitude * 0.0175) *    \r\n" + 
//			"                 cos((:longitude * 0.0175) - (a.Longitude * 0.0175))\r\n" + 
//			"              ) * 3959 \r\n" + 
//			"      )";
//
//	@Query(value = SQL_RAIO_ANUNCIO)
//	Page<Anuncio> findAnuncioRaio(Pageable page, @Param("latitude") Double latitude,  @Param("longitude")Double longitude);
	
}
