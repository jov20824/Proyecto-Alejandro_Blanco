package com.alamesa.proyecto.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alamesa.proyecto.dto.contiene.ContieneRequestDto;
import com.alamesa.proyecto.dto.pedido.PedidoRequestDto;
import com.alamesa.proyecto.dto.pedido.PedidoResponseDto;
import com.alamesa.proyecto.entity.Cliente;
import com.alamesa.proyecto.entity.Contiene;
import com.alamesa.proyecto.entity.Pedido;
import com.alamesa.proyecto.entity.Plato;
import com.alamesa.proyecto.mapper.PedidoMapper;
import com.alamesa.proyecto.repository.ClienteRepository;
import com.alamesa.proyecto.repository.PedidoRepository;
import com.alamesa.proyecto.repository.PlatoRepository;
import com.alamesa.proyecto.service.PedidoService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	PlatoRepository platoRepository;
	
	@Autowired
    private ClienteRepository clienteRepository;
	
	@Autowired
	PedidoMapper pedidoMapper;

	@Override
	public PedidoResponseDto findById(Long id) {
		
		Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);

		if (pedidoOptional.isEmpty()) {
			log.error("No existe un pedido con ese id, id: " + id);
			throw new IllegalArgumentException("No existe un pedido con ese id");
		}
		return pedidoMapper.mapToPedidoDto(pedidoOptional.get());
	}

	@Override
	public List<PedidoResponseDto> findByClienteUsuarioEmail(String email) {
		List<Pedido> pedidos = pedidoRepository.findByClienteUsuarioEmail(email);
		return pedidoMapper.mapToPedidoDto(pedidos);
	}
	
	@Override
	public List<PedidoResponseDto> findDistinctByContienePlatoId(Long idPlato) {
		List<Pedido> pedidos = pedidoRepository.findDistinctByContienePlatoId(idPlato);
		return pedidoMapper.mapToPedidoDto(pedidos);
	}
	
	@Override
	public List<PedidoResponseDto> findAll() {
		List<Pedido> pedidos = pedidoRepository.findAll();
		return pedidoMapper.mapToPedidoDto(pedidos);
	}

	@Override
	public List<PedidoResponseDto> findAllByOrderByFechaRealizadoAsc() {
		List<Pedido> pedidos = pedidoRepository.findAllByOrderByFechaRealizadoAsc();
		return pedidoMapper.mapToPedidoDto(pedidos);
	}
	
	@Override
	public List<PedidoResponseDto> findAllByOrderByFechaRealizadoDesc() {
		List<Pedido> pedidos = pedidoRepository.findAllByOrderByFechaRealizadoDesc();
		return pedidoMapper.mapToPedidoDto(pedidos);
	}

	@Override
	public PedidoResponseDto add(PedidoRequestDto dto) {
		
		 Pedido pedido = new Pedido();
	        
        Optional<Cliente> cliente = clienteRepository.findById(dto.getCliente().getId());
        
        pedido.setCliente(cliente.get());
       
        pedido.setHoraReserva(dto.getHoraReserva());
        
        List<Contiene> contieneList = new ArrayList<>();
        for (ContieneRequestDto contieneRequestDto : dto.getContiene()) {
            Contiene contiene = new Contiene();
            Optional<Plato> plato = platoRepository.findById(contieneRequestDto.getPlato().getId());
            
            contiene.setPlato(plato.get());
            contiene.setCantidad(contieneRequestDto.getCantidad());
            contiene.setPedido(pedido);
            contieneList.add(contiene);
        }
        pedido.setContiene(contieneList);

        Pedido savedPedido = pedidoRepository.save(pedido);
        
        return pedidoMapper.mapPedidoRequestDtoToPedidoResponseDto(dto);
		
//		Pedido pedido = pedidoMapper.mapPedidoRequestDtoToPedido(dto);
//		
//		for (Contiene contiene : pedido.getContiene()) {
//            contiene.setPedido(pedido);
//            if (platoRepository.findById(contiene.getPlato().getId()).isEmpty()) {
//                return null;
//            }
//        }
//		
//		pedidoRepository.save(pedido);
//		return pedidoMapper.mapPedidoRequestDtoToPedidoResponseDto(dto);
	}

	@Override
	public PedidoResponseDto update(Long id, PedidoRequestDto dto) {
		
		Pedido pedido = pedidoRepository.findById(id).get();

		Optional<Cliente> cliente = clienteRepository.findById(dto.getCliente().getId());
        
        pedido.setCliente(cliente.get());
        pedido.setHoraReserva(dto.getHoraReserva());
        
        for(Contiene c: pedido.getContiene()) {
        	c.setPedido(null);
        }
        pedido.setContiene(null);
        
        List<Contiene> contieneList = new ArrayList<>();
        for (ContieneRequestDto contieneRequestDto : dto.getContiene()) {
            Contiene contiene = new Contiene();
            Optional<Plato> plato = platoRepository.findById(contieneRequestDto.getPlato().getId());
            
            contiene.setPlato(plato.get());
            contiene.setCantidad(contieneRequestDto.getCantidad());
            contiene.setPedido(pedido);
            contieneList.add(contiene);
        }
       
        pedido.setContiene(contieneList);

        pedidoRepository.save(pedido);
        
        return pedidoMapper.mapPedidoRequestDtoToPedidoResponseDto(dto);
	}

	@Override
	public void delete(Long id) {
		if (!pedidoRepository.findById(id).isPresent()) {
			log.error("No existe un pedido con ese id, id: " + id);
			throw new IllegalArgumentException("No existe un pedido con ese id");
		}
		pedidoRepository.deleteById(id);
	}

}


