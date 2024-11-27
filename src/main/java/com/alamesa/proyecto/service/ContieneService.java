package com.alamesa.proyecto.service;

import java.util.List;

import com.alamesa.proyecto.dto.contiene.ContieneRequestDto;
import com.alamesa.proyecto.dto.contiene.ContieneResponseDto;

public interface ContieneService {

	/**
	 * 
	 * @param id del usuario a buscar
	 * @return devuelve un dto del contiene
	 */
	ContieneResponseDto findById(Long id);

	/**
	 * 
	 * @return una lista de dtos con todos los contienes de la bd
	 */
	List<ContieneResponseDto> findAll();
	
	/**
	 * 
	 * @param dto: nombre del contiene que se quiere introducir
	 * @return devuelve el contiene creado
	 */
	ContieneResponseDto add(ContieneRequestDto dto);

	/**
	 * 
	 * @param id   del contiene que se quiere modificar
	 * @param dto: el nombre nuevo que se le quiere dar al contiene
	 * @return devuelve el contiene modificado
	 */
	ContieneResponseDto update(Long id, ContieneRequestDto dto);

	/**
	 * 
	 * @param id del contiene a borrar
	 */
	void delete(Long id);
}
