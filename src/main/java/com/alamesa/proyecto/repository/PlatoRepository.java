package com.alamesa.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alamesa.proyecto.entity.Plato;

public interface PlatoRepository extends JpaRepository<Plato, Long> {

//	@Query("SELECT p FROM Plato p WHERE p.categoria = :categoria")
//	List<Plato> findPlatosByCategoria(@Param("categoria") Categoria categoria);
	
	List<Plato> findAllByOrderByPrecioAsc();
	
	List<Plato> findAllByOrderByPrecioDesc();
}
