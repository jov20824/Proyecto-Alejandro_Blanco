package com.alamesa.proyecto.service;

import java.util.List;

import com.alamesa.proyecto.dto.plato.PlatoRequestDto;
import com.alamesa.proyecto.dto.plato.PlatoResponseDto;

public interface PlatoService {

	/**
	 * 
	 * @param id del usuario a buscar
	 * @return devuelve un dto del plato
	 */
	PlatoResponseDto findById(Long id);

	/**
	 * 
	 * @return una lista de dtos con todos los platos de la bd
	 */
	List<PlatoResponseDto> findAll();
	
	/**
	 * 
	 * @return una lista con los productos ordenador por precio en orden ascendente
	 */
	public List<PlatoResponseDto> findAllByOrderByPrecioAsc();
	
	/**
	 * 
	 * @return una lista con los productos ordenador por precio en orden ascendente
	 */
	public List<PlatoResponseDto> findAllByOrderByPrecioDesc();
	
	/**
	 * 
	 * @param categoria de los productos que se quieren obtener
	 * @return lista de productos pertenecientes a la categoria indicada
	 */
//	public List<PlatoResponseDto> findPlatosByCategoria(Long categoria);
	
	/**
	 * 
	 * @param dto: nombre del plato que se quiere introducir
	 * @return devuelve el plato creado
	 */
	PlatoResponseDto add(PlatoRequestDto dto);

	/**
	 * 
	 * @param id   del plato que se quiere modificar
	 * @param dto: el nombre nuevo que se le quiere dar al plato
	 * @return devuelve el plato modificado
	 */
	PlatoResponseDto update(Long id, PlatoRequestDto dto);

	/**
	 * 
	 * @param id del plato a borrar
	 */
	void delete(Long id);
}
