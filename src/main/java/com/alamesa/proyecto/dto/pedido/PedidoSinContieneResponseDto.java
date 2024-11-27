package com.alamesa.proyecto.dto.pedido;

import java.time.LocalDateTime;
import java.util.Date;

import com.alamesa.proyecto.dto.cliente.ClienteSinPedidosResponseDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PedidoSinContieneResponseDto {

	private Long id;
	
	private Date fechaRealizado;
	
	private LocalDateTime horaReserva;
	
	private ClienteSinPedidosResponseDto cliente;
}
