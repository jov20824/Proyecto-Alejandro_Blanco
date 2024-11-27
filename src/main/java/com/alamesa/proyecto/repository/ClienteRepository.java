package com.alamesa.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alamesa.proyecto.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	@Query("SELECT c FROM Cliente c LEFT JOIN c.pedidos p GROUP BY c.id ORDER BY COUNT(p) ASC")
    List<Cliente> findAllOrderByNumeroDePedidosAsc();
	
	@Query("SELECT c FROM Cliente c LEFT JOIN c.pedidos p GROUP BY c.id ORDER BY COUNT(p) DESC")
    List<Cliente> findAllOrderByNumeroDePedidosDesc();
	
	Cliente findByUsuarioId(Long id);
}
