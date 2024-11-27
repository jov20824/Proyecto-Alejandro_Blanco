package com.alamesa.proyecto.dto.plato;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PlatoRequestDto {

	@NotBlank
	@Size(max=75)
	private String nombre;
	
	private String descripcion;
	
	@Digits(integer=5,fraction=2)
	private float precio;
	
	private String foto;
}
