package com.alamesa.proyecto.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.alamesa.proyecto.dto.cliente.ClienteRequestDto;
import com.alamesa.proyecto.dto.cliente.ClienteResponseDto;
import com.alamesa.proyecto.dto.cliente.ClienteSinPedidosResponseDto;
import com.alamesa.proyecto.entity.Cliente;

@Mapper(componentModel="spring")
public interface ClienteMapper {

	public ClienteResponseDto mapToClienteDto(Cliente cliente);

	public ClienteSinPedidosResponseDto mapToClienteSPDto(Cliente cliente);
	
	public List<ClienteSinPedidosResponseDto> mapToClienteSPDto(List<Cliente> clientes);
	
	public List<ClienteResponseDto> mapToClienteDto(List<Cliente> clientes);
	
	public Cliente mapClienteRequestDtoToCliente(ClienteRequestDto clienteDto);
	
	public Cliente mapToCliente(Long id, ClienteRequestDto clienteDto);
	
	public ClienteResponseDto mapClienteRequestDtoToClienteResponseDto(ClienteRequestDto clienteDto);
}
