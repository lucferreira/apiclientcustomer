package com.socity.apipleasecustomer.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socity.apipleasecustomer.model.Loja;
import com.socity.apipleasecustomer.repository.LojaRepository;
import com.socity.apipleasecustomer.service.LojaService;

@Service
public class LojaServiceImpl implements LojaService{
	
	@Autowired
	private LojaRepository lojaRepository;

	@Override
	public List<Loja> listarTodosLojas() {
		return lojaRepository.findAll();
	}

	@Override
	public Loja exibirLoja(Long idloja) {
		return lojaRepository.findByIdloja(idloja);
	}

	@Override
	public Loja salvarLoja(Loja loja) {
		return lojaRepository.save(loja);
	}

	@Override
	public Loja atualizarLoja(Long idloja, Loja loja) {
		return lojaRepository.save(loja);
	}

}
