package br.com.ufg.fipetsws.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import br.com.ufg.fipetsws.dto.RacaCreateDto;
import br.com.ufg.fipetsws.dto.RacaDto;
import br.com.ufg.fipetsws.entities.Raca;

@Mapper
public interface RacaMapper {
	RacaMapper INSTANCE = Mappers.getMapper(RacaMapper.class);
	
	RacaDto paraDto(Raca raca);
	
	List<RacaDto> paraDto(List<Raca> listRaca);
	
    @Mappings(@Mapping(target = "id", ignore = true))
    Raca doDto (RacaDto source);
    
    @Mappings(@Mapping(target = "id", ignore = true))
    Raca doCreateDto (RacaCreateDto source);
    
    void atualizar(RacaDto source, @MappingTarget Raca target);
}
