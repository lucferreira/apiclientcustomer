package com.socity.apipleasecustomer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socity.apipleasecustomer.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	
	public Endereco deletarEnderecoById(Long idendereco);

}
