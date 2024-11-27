package com.alamesa.proyecto.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.alamesa.proyecto.dto.plato.PlatoConIdRequestDto;
import com.alamesa.proyecto.dto.plato.PlatoRequestDto;
import com.alamesa.proyecto.dto.plato.PlatoResponseDto;
import com.alamesa.proyecto.entity.Plato;

@Mapper(componentModel="spring")
public interface PlatoMapper {

	public PlatoResponseDto mapToPlatoDto(Plato plato);

	public List<PlatoResponseDto> mapToPlatoDto(List<Plato> platos);
	
	public Plato mapPlatoRequestDtoToPlato(PlatoRequestDto platoDto);
	
	public Plato mapPlatoConIdRequestDtoToPlato(PlatoConIdRequestDto platoDto);
	
	public Plato mapToPlato(Long id, PlatoRequestDto platoDto);
	
	public PlatoResponseDto mapPlatoRequestDtoToPlatoResponseDto(PlatoRequestDto platoDto);
}
