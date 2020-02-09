package com.socity.apipleasecustomer.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socity.apipleasecustomer.model.Preferencias;
import com.socity.apipleasecustomer.repository.PreferenciasRepository;
import com.socity.apipleasecustomer.service.PreferenciaService;

@Service
public class PreferenciaServiceImpl implements PreferenciaService{
	
	@Autowired
	private PreferenciasRepository preferenciaRepository;

	@Override
	public List<Preferencias> listarTodosPreferencias() {
		return preferenciaRepository.findAll();
	}

	@Override
	public Preferencias exibirPreferencias(Long idpreferencias) {
		return preferenciaRepository.findById(idpreferencias).get();
	}

	@Override
	public Preferencias salvarPreferencias(Preferencias preferencias) {
		return preferenciaRepository.save(preferencias);
	}

	@Override
	public Preferencias atualizarPreferencias(Long idpreferencias, Preferencias preferencias) {
		return preferenciaRepository.save(preferencias);
	}

}
