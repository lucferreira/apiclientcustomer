package com.socity.apipleasecustomer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.socity.apipleasecustomer.model.Loja;
import com.socity.apipleasecustomer.service.LojaService;

@RestController
@RequestMapping("/loja")
public class LojaController {
	
	@Autowired
	private LojaService lojaService;
	
	@GetMapping(path = "/todos", produces = "application/json")
	public ResponseEntity<List<Loja>> exibirTodasAsLojasCadastradas(){
		List<Loja> lojas = lojaService.listarTodosLojas();
		if(lojas.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum dado salvo no banco.");
		}
		return ResponseEntity.ok(lojas);
	}
	
	@GetMapping(path = "/{idloja}", produces = "application/json")
	public ResponseEntity<Loja> exibirLojaPorId(@PathVariable Long idloja){
		Loja loja = lojaService.exibirLoja(idloja);
		if(loja == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não cadastrado.");
		}
		return ResponseEntity.ok(loja);
	}
	
	@PostMapping(path = "/novo", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Loja> incluirNovaLoja(@RequestBody Loja loja){
		Long idloja = loja.getIdloja();
		Loja loj = lojaService.exibirLoja(idloja);
		if(loj != null) {
			throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Cliente já cadastrado.");
		}
		lojaService.salvarLoja(loja);
		return ResponseEntity.ok(loja);
	}
	

}
