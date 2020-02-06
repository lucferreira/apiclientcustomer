package com.socity.apipleasecustomer.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idendereco")
public class Endereco {

	@Getter @Setter
	private Long idendereco;
	@Getter @Setter
	private String logradouro;
	@Getter @Setter
	private String bairro;
	@Getter @Setter
	private String cep;
	@Getter @Setter
	private String cidade;
	@Getter @Setter
	private String estado;
	@Getter @Setter
	private String obs;

}
