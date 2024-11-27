package com.alamesa.proyecto.service;

import java.util.List;

import com.alamesa.proyecto.dto.usuario.UsuarioRequestDto;
import com.alamesa.proyecto.dto.usuario.UsuarioResponseDto;

public interface UsuarioService {

	/**
	 * 
	 * @param id del usuario a buscar
	 * @return devuelve un dto del usuario
	 */
	UsuarioResponseDto findById(Long id);

	/**
	 * 
	 * @return una lista de dtos con todos los usuarios de la bd
	 */
	List<UsuarioResponseDto> findAll();
	
	/**
	 * 
	 * @return una lista de dtos con todos los usuarios sin cliente asociado de la bd
	 */
	List<UsuarioResponseDto> findByClienteIsNull();
	
	/**
	 * 
	 * @param categoria de los productos que se quieren obtener
	 * @return lista de productos pertenecientes a la categoria indicada
	 */
//	public List<UsuarioResponseDto> findUsuariosByCategoria(Long categoria);
	
	/**
	 * 
	 * @param dto: nombre del usuario que se quiere introducir
	 * @return devuelve el usuario creado
	 */
	UsuarioResponseDto add(UsuarioRequestDto dto);

	/**
	 * 
	 * @param id   del usuario que se quiere modificar
	 * @param dto: el nombre nuevo que se le quiere dar al usuario
	 * @return devuelve el usuario modificado
	 */
	UsuarioResponseDto update(Long id, UsuarioRequestDto dto);

	/**
	 * 
	 * @param id del usuario a borrar
	 */
	void delete(Long id);
}
