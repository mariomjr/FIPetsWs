package br.com.ufg.fipetsws.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

import br.com.ufg.fipetsws.dto.AnuncioCreateDto;
import br.com.ufg.fipetsws.dto.AnuncioDto;
import br.com.ufg.fipetsws.entities.Anuncio;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AnuncioMapper {
	AnuncioMapper INSTANCE = Mappers.getMapper(AnuncioMapper.class);
	
	AnuncioDto paraDto(Anuncio usuario);
	
	List<AnuncioDto> paraDto(List<Anuncio> listRaca);
	
    @Mappings(@Mapping(target = "id", ignore = true))
    Anuncio doDto (AnuncioDto source);
    
    @Mappings(@Mapping(target = "id", ignore = true))
    Anuncio doCreateDto (AnuncioCreateDto source);
    
    void atualizar(AnuncioDto source, @MappingTarget Anuncio target);
}
