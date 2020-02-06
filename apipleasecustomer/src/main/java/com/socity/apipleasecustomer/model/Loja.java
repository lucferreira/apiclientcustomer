package com.socity.apipleasecustomer.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idloja")
public class Loja {
	
	@Getter @Setter
	private Long idloja;
	@Getter @Setter
	private String nome;
	@Getter @Setter
	private String cnpj;
	@Getter @Setter
	private String insc_estadual;
	@Getter @Setter
	private String categoria;
	@Getter @Setter
	private LocalDate data_cad;

}
