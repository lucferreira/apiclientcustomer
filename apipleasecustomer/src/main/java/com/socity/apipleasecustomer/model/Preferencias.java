package com.socity.apipleasecustomer.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idpreferencia")
public class Preferencias {
	
	@Getter @Setter
	private Long idpreferencia;
	@Getter @Setter
	private String categoria;
	@Getter @Setter
	private String descricao;
	

}
