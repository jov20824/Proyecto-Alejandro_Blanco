package com.alamesa.proyecto.service;

import org.springframework.http.ResponseEntity;

import com.alamesa.proyecto.dto.ApiResponse;
import com.alamesa.proyecto.dto.login.LoginRequestDTO;
import com.alamesa.proyecto.dto.register.RegisterRequestDTO;

public interface AuthService {

	public ResponseEntity<ApiResponse<Object>> register(RegisterRequestDTO request);
	
	public ResponseEntity<?> login(LoginRequestDTO request);
}
