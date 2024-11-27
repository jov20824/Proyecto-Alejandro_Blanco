package com.alamesa.proyecto.dto.plato;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PlatoResponseDto {

	private Long id;
	
	private String nombre;
	
	private String descripcion;
	
	private float precio;
	
	private String foto;

}
