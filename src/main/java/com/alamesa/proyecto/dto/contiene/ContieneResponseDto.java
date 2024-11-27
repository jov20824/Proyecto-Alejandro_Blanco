package com.alamesa.proyecto.dto.contiene;

import com.alamesa.proyecto.dto.pedido.PedidoSinContieneResponseDto;
import com.alamesa.proyecto.dto.plato.PlatoResponseDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ContieneResponseDto {

	private PedidoSinContieneResponseDto pedido;
	
	private PlatoResponseDto plato;
	
	private int cantidad;
}
