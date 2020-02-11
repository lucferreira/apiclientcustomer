package com.socity.apipleasecustomer.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.socity.apipleasecustomer.model.Cliente;
import com.socity.apipleasecustomer.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;

	@GetMapping(path = "/todos", produces = "application/json")
	public ResponseEntity<List<Cliente>> exibirTodosOsClientes(){
		List<Cliente> clientes = clienteService.listarTodosClientes();
		if(clientes.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum cliente cadastrado.");
		}
			return ResponseEntity.ok(clientes);
		
	}
	
	@GetMapping(path = "/{idcliente}", produces = "application/json")
	public ResponseEntity<Cliente> exibirCliente(@PathVariable Long idcliente){
		Cliente cliente = clienteService.exibirCliente(idcliente);
		if(cliente == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum cliente cadastrado.");
		}
		return ResponseEntity.ok(cliente);
		
	}
	
	@PostMapping(path = "/novo", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Cliente> incluirNovoCliente(@RequestBody Cliente cliente){
//		if(cliente == null) {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Dados vazios.");
//		}
		Long idCliente = cliente.getIdcliente();
		Cliente cli = clienteService.exibirCliente(idCliente);
		if(cli != null) {
			throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Cliente já cadastrado.");
		}
		clienteService.salvarCliente(cliente);
		return ResponseEntity.ok(cliente);
	}
	@PutMapping(path = "/altercliente/{idcliente}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Cliente> atualizarDadosCliente(@PathVariable Long idcliente, @RequestBody Cliente cliente){
		if (idcliente == null && cliente == null) {
			throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Dados do cliente vazio."); 
		}
		Cliente ci = clienteService.exibirCliente(cliente.getIdcliente());
		
		if (ci == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado.");
		}
		BeanUtils.copyProperties(ci, cliente);
		clienteService.salvarCliente(cliente);
		
		return ResponseEntity.ok(cliente);
		
	}
	
	
}
