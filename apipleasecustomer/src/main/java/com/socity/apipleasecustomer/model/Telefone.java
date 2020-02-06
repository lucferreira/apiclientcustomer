package com.socity.apipleasecustomer.model;

import com.socity.apipleasecustomer.util.TipoTelefone;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idtelefone")
public class Telefone {
	
	@Getter @Setter
	private Long idtelefone;
	@Getter @Setter
	private TipoTelefone tipoTelefone;
	@Getter @Setter
	private String numero;

}
