package com.alamesa.proyecto.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.alamesa.proyecto.dto.pedido.PedidoRequestDto;
import com.alamesa.proyecto.dto.pedido.PedidoResponseDto;
import com.alamesa.proyecto.dto.pedido.PedidoSinContieneResponseDto;
import com.alamesa.proyecto.entity.Pedido;

@Mapper(componentModel="spring")
public interface PedidoMapper {

	public PedidoResponseDto mapToPedidoDto(Pedido pedido);

	public List<PedidoResponseDto> mapToPedidoDto(List<Pedido> pedidos);
	
	public PedidoSinContieneResponseDto mapToPedidoSCResponseDto(Pedido pedido);
	
	public List<PedidoSinContieneResponseDto> mapToPedidoSCResponseDto(List<Pedido> pedido);
	
	public Pedido mapPedidoRequestDtoToPedido(PedidoRequestDto pedidoDto);
	
	public Pedido mapToPedido(Long id, PedidoRequestDto pedidoDto);
	
	public PedidoResponseDto mapPedidoRequestDtoToPedidoResponseDto(PedidoRequestDto pedidoDto);
}
