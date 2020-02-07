package com.socity.apipleasecustomer.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socity.apipleasecustomer.model.Brinde;
import com.socity.apipleasecustomer.repository.BrindeRepository;
import com.socity.apipleasecustomer.service.BrindeService;

@Service
public class BrindeServiceImpl implements BrindeService{
	
	@Autowired
	private BrindeRepository brindeRepository;

	@Override
	public List<Brinde> listarTodosBrindes() {
		return brindeRepository.findAll();
	}

	@Override
	public Brinde exibirBrinde(Long idbrinde) {
		return brindeRepository.findById(idbrinde).get();
	}

	@Override
	public Brinde salvarBrinde(Brinde brinde) {
		return brindeRepository.save(brinde);
	}

	@Override
	public Brinde atualizarBrinde(Long idbrinde, Brinde brinde) {
		return brindeRepository.save(brinde);
	}

	@Override
	public Brinde deletarBrinde(Long idbrinde) {
		return brindeRepository.deletarBrindeById(idbrinde);
	}

}
