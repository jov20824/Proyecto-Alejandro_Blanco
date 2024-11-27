package com.alamesa.proyecto.dto.pedido;

import java.time.LocalDateTime;
import java.util.List;

import com.alamesa.proyecto.dto.cliente.ClienteConIdRequestDto;
import com.alamesa.proyecto.dto.contiene.ContieneRequestDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PedidoRequestDto {
	
	private LocalDateTime horaReserva;

	private List<ContieneRequestDto> contiene;

	private ClienteConIdRequestDto cliente;
	
}
