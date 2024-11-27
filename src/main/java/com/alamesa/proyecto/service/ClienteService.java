package com.alamesa.proyecto.service;

import java.util.List;

import com.alamesa.proyecto.dto.cliente.ClienteRequestDto;
import com.alamesa.proyecto.dto.cliente.ClienteResponseDto;

public interface ClienteService {
	
	/**
	 * 
	 * @param id del usuario a buscar
	 * @return devuelve un dto del cliente
	 */
	ClienteResponseDto findById(Long id);

	/**
	 * 
	 * @return una lista de dtos con todos los clientes de la bd
	 */
	List<ClienteResponseDto> findAll();
	
	/**
	 * 
	 * @return una lista con los clientes ordenados por orden ascendente
	 */
	List<ClienteResponseDto> findAllOrderByNumeroDePedidosAsc();
	
	/**
	 * 
	 * @return una lista con los clientes ordenados por orden descendente
	 */
	List<ClienteResponseDto> findAllOrderByNumeroDePedidosDesc();
	
	/**
	 * 
	 * @param dto: nombre del cliente que se quiere introducir
	 * @return devuelve el cliente creado
	 */
	ClienteResponseDto add(ClienteRequestDto dto);

	/**
	 * 
	 * @param id   del cliente que se quiere modificar
	 * @param dto: el nombre nuevo que se le quiere dar al cliente
	 * @return devuelve el cliente modificado
	 */
	ClienteResponseDto update(Long id, ClienteRequestDto dto);

	/**
	 * 
	 * @param id del cliente a borrar
	 */
	void delete(Long id);
}
