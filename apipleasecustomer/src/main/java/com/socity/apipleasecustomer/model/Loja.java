package com.socity.apipleasecustomer.model;

import java.util.Date;

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
@EqualsAndHashCode(of = "idloja")
@Entity
public class Loja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date data_cadast;

}
