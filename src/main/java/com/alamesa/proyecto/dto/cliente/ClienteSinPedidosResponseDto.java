package com.alamesa.proyecto.dto.cliente;

import com.alamesa.proyecto.dto.usuario.UsuarioResponseDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClienteSinPedidosResponseDto {

	private String nombre;
	
	private int telefono;
	
	private UsuarioResponseDto usuario;
}
