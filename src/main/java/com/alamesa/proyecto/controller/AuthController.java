package com.alamesa.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alamesa.proyecto.dto.ApiResponse;
import com.alamesa.proyecto.dto.login.LoginRequestDTO;
import com.alamesa.proyecto.dto.register.RegisterRequestDTO;
import com.alamesa.proyecto.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;
    

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO request) {

       return authService.login(request);

    }


    @PostMapping("/register")
    public ResponseEntity<ApiResponse<Object>> register(@RequestBody RegisterRequestDTO request)  {

    	return authService.register(request);

    }

}