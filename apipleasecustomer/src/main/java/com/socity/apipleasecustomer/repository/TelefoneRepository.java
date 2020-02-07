package com.socity.apipleasecustomer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socity.apipleasecustomer.model.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
	
	public Telefone deletarTelefoneById(Long idtelefone);

}
