package com.alamesa.proyecto.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.alamesa.proyecto.entity.Usuario;
import com.alamesa.proyecto.repository.UsuarioRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    
    @Autowired
	private UsuarioRepository usuarioRepository;
	
    @Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
		
		if(usuario.isPresent()) {
			return (UserDetails)usuario.get();
		}
		throw new UsernameNotFoundException("El usuario con mail "+email+" no existe");
	}

}
