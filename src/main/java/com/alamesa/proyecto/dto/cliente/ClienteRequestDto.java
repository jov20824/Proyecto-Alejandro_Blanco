package com.alamesa.proyecto.dto.cliente;

import com.alamesa.proyecto.dto.usuario.UsuarioRequestDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClienteRequestDto {
	
	private String nombre;
	
	private int telefono;
	
	private UsuarioRequestDto usuario;

}
