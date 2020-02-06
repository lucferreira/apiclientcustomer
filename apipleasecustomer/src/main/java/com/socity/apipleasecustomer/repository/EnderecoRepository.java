package com.socity.apipleasecustomer.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.socity.apipleasecustomer.model.Endereco;

@Repository
public interface EnderecoRepository {

	public List<Endereco> exibirEnderecos();
	
	public Endereco exibirEndereco();
	
	public Endereco salvarEndereco(Endereco endereco);
	
	public Endereco atualizarEndereco(Long idendereco, Endereco endereco);
	
	public void excluirEndereco(Long idendereco);
	
}
