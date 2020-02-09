package com.socity.apipleasecustomer.service;

import java.util.List;

import com.socity.apipleasecustomer.model.Cliente;

public interface ClienteService {
	
	public List<Cliente> listarTodosClientes();
	
	public Cliente exibirCliente(Long idcliente);
	
	public Cliente salvarCliente(Cliente cliente);
	
	public Cliente atualizarCliente(Long idcliente, Cliente cliente);
	
}
