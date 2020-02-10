package com.socity.apipleasecustomer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.socity.apipleasecustomer.util.TipoTelefone;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idtelefone")
@Entity
public class Telefone {
	
	@Getter @Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idtelefone;
	@Getter @Setter
	private TipoTelefone tipoTelefone;
	@Getter @Setter
	private String numero;

}
