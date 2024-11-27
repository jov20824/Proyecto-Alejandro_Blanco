package com.alamesa.proyecto.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alamesa.proyecto.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	@Query("SELECT u FROM Usuario u WHERE u.id NOT IN (SELECT c.usuario.id FROM Cliente c)")
	List<Usuario> findByClienteIsNull();

	Optional<Usuario> findByUsername(String username);
	
	Optional<Usuario> findByEmail(String email);
}
