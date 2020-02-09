package com.socity.apipleasecustomer.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socity.apipleasecustomer.model.Cliente;
import com.socity.apipleasecustomer.repository.ClienteRepository;
import com.socity.apipleasecustomer.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<Cliente> listarTodosClientes() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente exibirCliente(Long idcliente) {
		return clienteRepository.findById(idcliente).get();
	}

	@Override
	public Cliente salvarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public Cliente atualizarCliente(Long idcliente, Cliente cliente) {
		return clienteRepository.save(cliente);
	}

}
