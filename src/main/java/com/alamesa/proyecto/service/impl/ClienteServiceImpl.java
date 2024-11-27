package com.alamesa.proyecto.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alamesa.proyecto.dto.cliente.ClienteRequestDto;
import com.alamesa.proyecto.dto.cliente.ClienteResponseDto;
import com.alamesa.proyecto.entity.Cliente;
import com.alamesa.proyecto.mapper.ClienteMapper;
import com.alamesa.proyecto.repository.ClienteRepository;
import com.alamesa.proyecto.service.ClienteService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	ClienteMapper clienteMapper;

	@Override
	public ClienteResponseDto findById(Long id) {
		
		Optional<Cliente> clienteOptional = clienteRepository.findById(id);

		if (clienteOptional.isEmpty()) {
			log.error("No existe un cliente con ese id, id: " + id);
			throw new IllegalArgumentException("No existe un cliente con ese id");
		}
		return clienteMapper.mapToClienteDto(clienteOptional.get());
	}

	@Override
	public List<ClienteResponseDto> findAllOrderByNumeroDePedidosAsc() {
		List<Cliente> clientes = clienteRepository.findAllOrderByNumeroDePedidosAsc();
		return clienteMapper.mapToClienteDto(clientes);
	}
	
	@Override
	public List<ClienteResponseDto> findAllOrderByNumeroDePedidosDesc() {
		List<Cliente> clientes = clienteRepository.findAllOrderByNumeroDePedidosDesc();
		return clienteMapper.mapToClienteDto(clientes);
	}
	
	@Override
	public List<ClienteResponseDto> findAll() {
		List<Cliente> clientes = clienteRepository.findAll();
		return clienteMapper.mapToClienteDto(clientes);
	}

	

	@Override
	public ClienteResponseDto add(ClienteRequestDto dto) {
		clienteRepository.save(clienteMapper.mapClienteRequestDtoToCliente(dto));
		return clienteMapper.mapClienteRequestDtoToClienteResponseDto(dto);
	}

	@Override
	public ClienteResponseDto update(Long id, ClienteRequestDto dto) {
		Optional<Cliente> clienteOptional = clienteRepository.findById(id);

		if (clienteOptional.isPresent()) {
			Cliente cliente = clienteMapper.mapToCliente(id, dto);

			clienteRepository.save(cliente);

			return clienteMapper.mapClienteRequestDtoToClienteResponseDto(dto);
		}
		log.error("No existe un cliente con ese id, id: " + id);
		throw new IllegalArgumentException("No existe un cliente con ese id");
	}

	@Override
	public void delete(Long id) {
		if (!clienteRepository.findById(id).isPresent()) {
			log.error("No existe un cliente con ese id, id: " + id);
			throw new IllegalArgumentException("No existe un cliente con ese id");
		}
		clienteRepository.deleteById(id);
	}

}

