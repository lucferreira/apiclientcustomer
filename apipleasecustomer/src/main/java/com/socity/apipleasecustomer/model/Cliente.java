package com.socity.apipleasecustomer.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.br.CPF;

import com.socity.apipleasecustomer.util.Sexo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idcliente")
@Entity
public class Cliente {
	
	@Getter @Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idcliente;
	@Getter @Setter
	private String nome;
	@Getter @Setter
	@CPF
	private String cpf;
	@Getter @Setter
	private Sexo sexo;
	@Getter @Setter
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date data_nasc;
	@Getter @Setter
	private String email;

}
