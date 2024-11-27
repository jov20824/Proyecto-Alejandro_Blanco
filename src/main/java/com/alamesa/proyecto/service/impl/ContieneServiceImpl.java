package com.alamesa.proyecto.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alamesa.proyecto.dto.contiene.ContieneRequestDto;
import com.alamesa.proyecto.dto.contiene.ContieneResponseDto;
import com.alamesa.proyecto.entity.Contiene;
import com.alamesa.proyecto.mapper.ContieneMapper;
import com.alamesa.proyecto.repository.ContieneRepository;
import com.alamesa.proyecto.service.ContieneService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ContieneServiceImpl implements ContieneService {

	@Autowired
	ContieneRepository contieneRepository;

	@Autowired
	ContieneMapper contieneMapper;

	@Override
	public ContieneResponseDto findById(Long id) {
		
		Optional<Contiene> contieneOptional = contieneRepository.findById(id);

		if (contieneOptional.isEmpty()) {
			log.error("No existe un contiene con ese id, id: " + id);
			throw new IllegalArgumentException("No existe un contiene con ese id");
		}
		return contieneMapper.mapToContieneDto(contieneOptional.get());
	}

	@Override
	public List<ContieneResponseDto> findAll() {
		List<Contiene> contienes = contieneRepository.findAll();
		return contieneMapper.mapToContieneDto(contienes);
	}

	

	@Override
	public ContieneResponseDto add(ContieneRequestDto dto) {
		contieneRepository.save(contieneMapper.mapContieneRequestDtoToContiene(dto));
		return contieneMapper.mapContieneRequestDtoToContieneResponseDto(dto);
	}

	@Override
	public ContieneResponseDto update(Long id, ContieneRequestDto dto) {
		Optional<Contiene> contieneOptional = contieneRepository.findById(id);

		if (contieneOptional.isPresent()) {
			Contiene contiene = contieneMapper.mapToContiene(id, dto);

			contieneRepository.save(contiene);

			return contieneMapper.mapContieneRequestDtoToContieneResponseDto(dto);
		}
		log.error("No existe un contiene con ese id, id: " + id);
		throw new IllegalArgumentException("No existe un contiene con ese id");
	}

	@Override
	public void delete(Long id) {
		if (!contieneRepository.findById(id).isPresent()) {
			log.error("No existe un contiene con ese id, id: " + id);
			throw new IllegalArgumentException("No existe un contiene con ese id");
		}
		contieneRepository.deleteById(id);
	}

}


