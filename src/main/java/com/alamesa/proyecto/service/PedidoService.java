package com.alamesa.proyecto.service;

import java.util.List;

import com.alamesa.proyecto.dto.pedido.PedidoRequestDto;
import com.alamesa.proyecto.dto.pedido.PedidoResponseDto;

public interface PedidoService {

	/**
	 * 
	 * @param id del usuario a buscar
	 * @return devuelve un dto del pedido
	 */
	PedidoResponseDto findById(Long id);

	/**
	 * 
	 * @param email del usuario a buscar
	 * @return devuelve una lista de dtos del pedido
	 */
	List<PedidoResponseDto> findByClienteUsuarioEmail(String email);
	
	/**
	 * 
	 * @param id del plato a buscar
	 * @return devuelve una lista de dtos del pedido
	 */
	List<PedidoResponseDto> findDistinctByContienePlatoId(Long idPlato);
	
	/**
	 * 
	 * @return una lista de dtos con todos los pedidos de la bd
	 */
	List<PedidoResponseDto> findAll();
	
	/**
	 * 
	 * @return una lista de pedidos ordenados por fecha de manera ascendente
	 */
	List<PedidoResponseDto> findAllByOrderByFechaRealizadoAsc();
	
	/**
	 * 
	 * @return una lista de pedidos ordenados por fecha de manera descendente
	 */
	List<PedidoResponseDto> findAllByOrderByFechaRealizadoDesc();
	
	/**
	 * 
	 * @param dto: nombre del pedido que se quiere introducir
	 * @return devuelve el pedido creado
	 */
	PedidoResponseDto add(PedidoRequestDto dto);

	/**
	 * 
	 * @param id   del pedido que se quiere modificar
	 * @param dto: el nombre nuevo que se le quiere dar al pedido
	 * @return devuelve el pedido modificado
	 */
	PedidoResponseDto update(Long id, PedidoRequestDto dto);

	/**
	 * 
	 * @param id del pedido a borrar
	 */
	void delete(Long id);
}
