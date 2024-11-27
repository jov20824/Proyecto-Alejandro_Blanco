package com.alamesa.proyecto.dto.contiene;

import com.alamesa.proyecto.dto.plato.PlatoConIdRequestDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ContieneRequestDto {
	
	private PlatoConIdRequestDto plato;
	
	private int cantidad;
}
