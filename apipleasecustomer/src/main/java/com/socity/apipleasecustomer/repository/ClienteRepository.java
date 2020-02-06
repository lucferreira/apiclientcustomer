package com.socity.apipleasecustomer.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.socity.apipleasecustomer.model.Cliente;

@Repository
public interface ClienteRepository {
	
public List<Cliente> exibirClientes();
	
	public Cliente exibirCliente(Long idcliente);
	
	public Cliente consultaClientePorNome(String nome);
	
	public int salvarCliente(Cliente cliente);
	
	public int atualizarCliente(Long idcliente, Cliente cliente);
	
	public int excluirCliente(Long idcliente);

}
