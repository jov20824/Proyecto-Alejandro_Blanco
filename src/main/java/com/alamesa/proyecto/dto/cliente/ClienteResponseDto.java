package com.alamesa.proyecto.dto.cliente;

import java.util.List;

import com.alamesa.proyecto.dto.pedido.PedidoSinClienteResponseDto;
import com.alamesa.proyecto.dto.usuario.UsuarioResponseDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClienteResponseDto {

	private Long id;
	
	private String nombre;
	
	private int telefono;
	
	private UsuarioResponseDto usuario;

	private List<PedidoSinClienteResponseDto> pedidos;
}
