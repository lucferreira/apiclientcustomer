package com.socity.apipleasecustomer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socity.apipleasecustomer.model.Preferencias;
import com.socity.apipleasecustomer.service.PreferenciaService;

@RestController
@RequestMapping("/preferencias")
public class PreferenciaController {
	
	@Autowired
	private PreferenciaService preferenciaService;

	@GetMapping(path = "/todos", produces = "application/json")
	public ResponseEntity<List<Preferencias>> exibirPreferencias(){
		List<Preferencias> preferencias = preferenciaService.listarTodosPreferencias();
		return ResponseEntity.ok(preferencias);
	}
	
}
