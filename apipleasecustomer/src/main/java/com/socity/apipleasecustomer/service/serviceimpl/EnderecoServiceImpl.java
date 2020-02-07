package com.socity.apipleasecustomer.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socity.apipleasecustomer.model.Endereco;
import com.socity.apipleasecustomer.repository.EnderecoRepository;
import com.socity.apipleasecustomer.service.EnderecoService;

@Service
public class EnderecoServiceImpl implements EnderecoService{
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	@Override
	public List<Endereco> listarTodosEnderecos() {
		return enderecoRepository.findAll();
	}

	@Override
	public Endereco exibirEndereco(Long idendereco) {
		return enderecoRepository.findById(idendereco).get();
	}

	@Override
	public Endereco salvarEndereco(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

	@Override
	public Endereco atualizarEndereco(Long idendereco, Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

	@Override
	public Endereco deletarEndereco(Long idendereco) {
		return enderecoRepository.deletarEnderecoById(idendereco);
	}

}
