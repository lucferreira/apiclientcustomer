package com.socity.apipleasecustomer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socity.apipleasecustomer.model.Preferencias;

public interface PreferenciasRepository extends JpaRepository<Preferencias, Long> {
	
}
