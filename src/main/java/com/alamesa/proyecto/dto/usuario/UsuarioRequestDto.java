package com.alamesa.proyecto.dto.usuario;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UsuarioRequestDto {

	private Long id;
	
	private String email;
	
	private String username;
	
	private String password;
}
