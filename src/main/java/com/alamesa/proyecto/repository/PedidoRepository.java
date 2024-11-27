package com.alamesa.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alamesa.proyecto.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	List<Pedido> findAllByOrderByFechaRealizadoAsc();
	
	List<Pedido> findAllByOrderByFechaRealizadoDesc();
	
	List<Pedido> findByClienteUsuarioEmail(String email);
	
	List<Pedido> findDistinctByContienePlatoId(Long platoId);
}
