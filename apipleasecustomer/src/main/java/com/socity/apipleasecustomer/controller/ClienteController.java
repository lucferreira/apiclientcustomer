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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.socity.apipleasecustomer.model.Cliente;
import com.socity.apipleasecustomer.service.ClienteService;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;

	@GetMapping("/clientes")
	public ResponseEntity<List<Cliente>> exibirTodosOsClientes(){
		List<Cliente> clientes = clienteService.listarTodosClientes();
		if(clientes.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum cliente cadastrado.");
		}
			return ResponseEntity.ok(clientes);
		
	}
	
	@GetMapping("/cliente/{idcliente}")
	public ResponseEntity<Cliente> exibirCliente(@PathVariable Long idcliente){
		Cliente cliente = clienteService.exibirCliente(idcliente);
		if(cliente == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum cliente cadastrado.");
		}
		return ResponseEntity.ok(cliente);
		
	}
	
	@PostMapping("/cliente")
	public ResponseEntity<Cliente> incluirNovoCliente(@RequestBody Cliente cliente){
		if(cliente == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Dados vazios.");
		}
		Cliente cli = clienteService.exibirCliente(cliente.getIdcliente());
		if(cli != null) {
			throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Cliente já cadastrado.");
		}
		clienteService.salvarCliente(cliente);
		return ResponseEntity.ok(cliente);
	}
	@PutMapping("/cliente")
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
