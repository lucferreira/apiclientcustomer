package com.socity.apipleasecustomer.service;

import java.util.List;

import com.socity.apipleasecustomer.model.Preferencias;

public interface PreferenciaService {

	public List<Preferencias> listarTodosPreferencias();

	public Preferencias exibirPreferencias(Long idpreferencias);

	public Preferencias salvarPreferencias(Preferencias preferencias);

	public Preferencias atualizarPreferencias(Long idpreferencias, Preferencias preferencias);

	public Preferencias deletarPreferencias(Long idpreferencias);

}
