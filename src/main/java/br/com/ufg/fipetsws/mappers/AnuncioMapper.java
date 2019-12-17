package br.com.ufg.fipetsws.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import br.com.ufg.fipetsws.dto.AnuncioCreateDto;
import br.com.ufg.fipetsws.dto.AnuncioDto;
import br.com.ufg.fipetsws.entities.Anuncio;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AnuncioMapper {
	AnuncioMapper INSTANCE = Mappers.getMapper(AnuncioMapper.class);
	
	AnuncioDto paraDto(Anuncio usuario);
	
	Page<AnuncioDto> paraDto(Page<Anuncio> listRaca);
	
    @Mappings(@Mapping(target = "id", ignore = true))
    Anuncio doDto (AnuncioDto source);
    
    @Mappings(@Mapping(target = "id", ignore = true))
    Anuncio doCreateDto (AnuncioCreateDto source);
    
    void atualizar(AnuncioDto source, @MappingTarget Anuncio target);
}
