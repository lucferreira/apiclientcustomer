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

import com.socity.apipleasecustomer.model.Cliente;
import com.socity.apipleasecustomer.repositoryimpl.ClienteRepositoryImpl;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteRepositoryImpl clienteRepositoryImpl;
	
	@GetMapping("/clientes")
	public ResponseEntity<List<Cliente>> listarClientes(){
		List<Cliente> clientes = clienteRepositoryImpl.exibirClientes();
		if(clientes.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum cliente cadastrado.");
		}
		return ResponseEntity.ok(clientes);
	}
	
	@GetMapping("/cliente/{idcliente}")
	public ResponseEntity<Cliente> exibiCliente(@PathVariable Long idcliente){
		Cliente cliente = clienteRepositoryImpl.exibirCliente(idcliente);
		if(cliente == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum cliente com esse id foi cadastrado.");
		}else {
			return ResponseEntity.ok(cliente);
		}
	}
	
	@PostMapping("/cliente")
	public ResponseEntity<String> incluirNovoCliente(@RequestBody Cliente cliente){
		if(cliente == null) {
			throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Nenhuma informação a ser cadastrada.");
		}else {
			clienteRepositoryImpl.salvarCliente(cliente);
			return ResponseEntity.ok("Cliente inserido com sucesso.");
		}
	}
	
	@PutMapping("/cliente/{idcliente}")
	public ResponseEntity<String> atualizarCliente(@PathVariable Long idcliente, @RequestBody Cliente cliente){
		if (idcliente == null || cliente == null) {
			throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Nenhuma informação a ser cadastrada.");
		}else {
			Cliente cli = clienteRepositoryImpl.exibirCliente(idcliente);
			if(cli == null) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum cliente cadastrado.");
			}
			BeanUtils.copyProperties(cliente, cli);
			clienteRepositoryImpl.atualizarCliente(idcliente, cliente);
			return ResponseEntity.ok("Cliente atualizado com sucesso.");
		}
	}
//	@DeleteMapping("/cliente/{idcliente}")
//	public ResponseEntity<String> excluirCliente(@PathVariable Long idcliente){
//		Cliente cliente = clienteRepositoryImpl.exibirCliente(idcliente);
//		if(cliente == null) {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum cliente com esse id foi cadastrado.");
//		}else {
//			clienteRepositoryImpl.excluirCliente(idcliente);
//			return ResponseEntity.ok("Cliente excluído com sucesso");
//		}
//	}
}
