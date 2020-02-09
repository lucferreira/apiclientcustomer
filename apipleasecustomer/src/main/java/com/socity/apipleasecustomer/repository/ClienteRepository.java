package com.socity.apipleasecustomer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socity.apipleasecustomer.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	
}
