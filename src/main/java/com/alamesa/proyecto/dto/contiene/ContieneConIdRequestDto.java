package com.alamesa.proyecto.dto.contiene;

import com.alamesa.proyecto.dto.pedido.PedidoSinContieneResponseDto;
import com.alamesa.proyecto.dto.plato.PlatoConIdRequestDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ContieneConIdRequestDto {

	private Long id;

	private PedidoSinContieneResponseDto pedido;
	
	private PlatoConIdRequestDto plato;
	
	private int cantidad;
}
