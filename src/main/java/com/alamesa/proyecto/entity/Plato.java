package com.alamesa.proyecto.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Plato {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String nombre;
	
	private String descripcion;
	
	private float precio;
	
	private String foto;
	

	@OneToMany(mappedBy="plato", cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<Contiene> contiene;
	
	
}
