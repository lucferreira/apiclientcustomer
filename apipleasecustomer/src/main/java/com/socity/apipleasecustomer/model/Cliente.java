package com.socity.apipleasecustomer.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idcliente")
public class Cliente {
	
	@Getter @Setter
	private Long idcliente;
	@Getter @Setter
	private String nome;
	@Getter @Setter
	private String cpf;
	@Getter @Setter
	private String sexo;
	@Getter @Setter
	private Date data_nasc;
	@Getter @Setter
	private String email;

}
