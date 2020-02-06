package com.socity.apipleasecustomer.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idbrinde")
public class Brinde {
	
	@Getter @Setter
	private Long idbrinde;
	@Getter @Setter
	private String nome;
	@Getter @Setter
	private String descricao;
	@Getter @Setter
	private LocalDate data_retir;
	@Getter @Setter
	private Boolean prodRetirado;

}
