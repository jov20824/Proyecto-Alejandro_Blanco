package com.alamesa.proyecto.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alamesa.proyecto.dto.plato.PlatoRequestDto;
import com.alamesa.proyecto.dto.plato.PlatoResponseDto;
import com.alamesa.proyecto.entity.Plato;
import com.alamesa.proyecto.mapper.PlatoMapper;
import com.alamesa.proyecto.repository.PlatoRepository;
import com.alamesa.proyecto.service.PlatoService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PlatoServiceImpl implements PlatoService {

	@Autowired
	PlatoRepository platoRepository;

	@Autowired
	PlatoMapper platoMapper;

	@Override
	public PlatoResponseDto findById(Long id) {
		
		Optional<Plato> platoOptional = platoRepository.findById(id);

		if (platoOptional.isEmpty()) {
			log.error("No existe un plato con ese id, id: " + id);
			throw new IllegalArgumentException("No existe un plato con ese id");
		}
		return platoMapper.mapToPlatoDto(platoOptional.get());
	}

	@Override
	public List<PlatoResponseDto> findAll() {
		List<Plato> platos = platoRepository.findAll();
		return platoMapper.mapToPlatoDto(platos);
	}

	

	@Override
	public PlatoResponseDto add(PlatoRequestDto dto) {
		platoRepository.save(platoMapper.mapPlatoRequestDtoToPlato(dto));
		return platoMapper.mapPlatoRequestDtoToPlatoResponseDto(dto);
	}

	@Override
	public PlatoResponseDto update(Long id, PlatoRequestDto dto) {
		Optional<Plato> platoOptional = platoRepository.findById(id);
		System.out.println(dto);
		if (platoOptional.isPresent()) {
			Plato plato = platoMapper.mapToPlato(id, dto);
			System.out.println(plato);
			platoRepository.save(plato);

			return platoMapper.mapPlatoRequestDtoToPlatoResponseDto(dto);
		}
		log.error("No existe un plato con ese id, id: " + id);
		throw new IllegalArgumentException("No existe un plato con ese id");
	}

	@Override
	public void delete(Long id) {
		if (!platoRepository.findById(id).isPresent()) {
			log.error("No existe un plato con ese id, id: " + id);
			throw new IllegalArgumentException("No existe un plato con ese id");
		}
		platoRepository.deleteById(id);
	}

	@Override
	public List<PlatoResponseDto> findAllByOrderByPrecioAsc() {
		
		return platoMapper.mapToPlatoDto(platoRepository.findAllByOrderByPrecioAsc());
	}

	@Override
	public List<PlatoResponseDto> findAllByOrderByPrecioDesc() {
		return platoMapper.mapToPlatoDto(platoRepository.findAllByOrderByPrecioDesc());
	}

}


