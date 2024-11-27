package com.alamesa.proyecto.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Contiene {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="pedido_id")
	@JsonBackReference("contiene_pedido")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name="plato_id")
	@JsonBackReference("contiene_plato")
	private Plato plato;
	
	private int cantidad;
}
