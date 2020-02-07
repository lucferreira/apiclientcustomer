package com.socity.apipleasecustomer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idpreferencia")
@Entity
public class Preferencias {
	
	@Getter @Setter
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idpreferencia;
	@Getter @Setter
	private String categoria;
	@Getter @Setter
	private String descricao;
	

}
