package com.socity.apipleasecustomer.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socity.apipleasecustomer.model.Telefone;
import com.socity.apipleasecustomer.repository.TelefoneRepository;
import com.socity.apipleasecustomer.service.TelefoneService;

@Service
public class TelefoneServiceImpl implements TelefoneService {
	
	@Autowired
	private TelefoneRepository telefoneRepository;

	@Override
	public List<Telefone> listarTodosTelefones() {
		return telefoneRepository.findAll();
	}

	@Override
	public Telefone exibirTelefone(Long idtelefone) {
		return telefoneRepository.findById(idtelefone).get();
	}

	@Override
	public Telefone salvarTelefone(Telefone telefone) {
		return telefoneRepository.save(telefone);
	}

	@Override
	public Telefone atualizarTelefone(Long idtelefone, Telefone telefone) {
		return telefoneRepository.save(telefone);
	}

	@Override
	public Telefone deletarTelefone(Long idtelefone) {
		return telefoneRepository.deletarTelefoneById(idtelefone);
	}

}
