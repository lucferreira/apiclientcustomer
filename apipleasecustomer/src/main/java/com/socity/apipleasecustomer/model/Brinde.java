package com.socity.apipleasecustomer.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idbrinde")
@Entity
public class Brinde {
	
	@Getter @Setter
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idbrinde;
	@Getter @Setter
	private String nome;
	@Getter @Setter
	private String descricao;
	@Getter @Setter
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate data_retir;
	@Getter @Setter
	private Boolean prodRetirado;

}
