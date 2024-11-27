package com.alamesa.proyecto.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.alamesa.proyecto.dto.auth.AuthResponseDTO;
import com.alamesa.proyecto.dto.login.LoginRequestDTO;
import com.alamesa.proyecto.entity.Usuario;
import com.alamesa.proyecto.repository.UsuarioRepository;
import com.alamesa.proyecto.service.JwtService;
import com.alamesa.proyecto.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	 	@Autowired
	    AuthenticationManager authManager; 

	    @Autowired
	    UsuarioRepository usuarioRepository; 

	    @Autowired
	    JwtService jwtService; 

	    @Override
	    public AuthResponseDTO autenticar(LoginRequestDTO request) throws DisabledException, BadCredentialsException {

	        authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

	        Optional<Usuario> user = usuarioRepository.findByUsername(request.getUsername());

	        String token = jwtService.getToken((UserDetails) user.get());

	        return AuthResponseDTO.builder().token(token).build();
	    }
}
