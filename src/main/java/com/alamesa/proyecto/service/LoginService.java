package com.alamesa.proyecto.service;

import com.alamesa.proyecto.dto.auth.AuthResponseDTO;
import com.alamesa.proyecto.dto.login.LoginRequestDTO;

public interface LoginService {

	public AuthResponseDTO autenticar(LoginRequestDTO request);
}
