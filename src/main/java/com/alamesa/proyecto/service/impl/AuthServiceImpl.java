package com.alamesa.proyecto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.alamesa.proyecto.dto.ApiResponse;
import com.alamesa.proyecto.dto.login.LoginRequestDTO;
import com.alamesa.proyecto.dto.register.RegisterRequestDTO;
import com.alamesa.proyecto.entity.Cliente;
import com.alamesa.proyecto.entity.Rol;
import com.alamesa.proyecto.entity.Usuario;
import com.alamesa.proyecto.repository.ClienteRepository;
import com.alamesa.proyecto.repository.UsuarioRepository;
import com.alamesa.proyecto.service.AuthService;
import com.alamesa.proyecto.service.JwtService;
import com.alamesa.proyecto.service.LoginService;
import com.alamesa.proyecto.util.ResponseUtil;

@Service
public class AuthServiceImpl implements AuthService{

	@Autowired
    UsuarioRepository usuarioRepository; 

    @Autowired
    JwtService jwtService; 

    @Autowired
    AuthenticationManager authManager; 

    @Autowired
    PasswordEncoder bcryptPasswordEncoder;

    @Autowired
    LoginService loginService; 
	
	@Autowired
	ClienteRepository clienteRepository;
    
    @Override
    public ResponseEntity<ApiResponse<Object>> register(RegisterRequestDTO request) {

    	try {
    		Usuario usuario = new Usuario();
            usuario.setUsername(request.getUsername());
            usuario.setPassword(bcryptPasswordEncoder.encode(request.getPassword()));
            usuario.setEmail(request.getCorreo());
            usuario.setRol(Rol.USER);
            usuarioRepository.save(usuario);

            Cliente cliente = new Cliente();
            cliente.setNombre(request.getNombre());
            cliente.setTelefono(request.getTelefono());
            cliente.setUsuario(usuario);
            
            clienteRepository.save(cliente);
            
            return ResponseUtil.response(null, HttpStatus.ACCEPTED, "Registrado con éxito");
            
    	}catch (Exception e) {
    		
    	}
    	
    	return ResponseUtil.response(null, HttpStatus.BAD_REQUEST, "No se ha conseguido registrar usuarios");

    }

    @Override
    public ResponseEntity<?> login(LoginRequestDTO request) {
        try {
        	
            return ResponseEntity.status(HttpStatus.OK).body(loginService.autenticar(request));
            
        } catch (DisabledException e) {
           
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
            
        } catch (BadCredentialsException e) {  
        	
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
            
        } catch (Exception e) {
           
            return null; 
        }
    }
}
