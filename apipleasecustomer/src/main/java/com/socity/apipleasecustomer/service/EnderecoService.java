package com.socity.apipleasecustomer.service;

import java.util.List;

import com.socity.apipleasecustomer.model.Endereco;

public interface EnderecoService {

	public List<Endereco> listarTodosEnderecos();

	public Endereco exibirEndereco(Long idendereco);

	public Endereco salvarEndereco(Endereco endereco);

	public Endereco atualizarEndereco(Long idendereco, Endereco endereco);

}
