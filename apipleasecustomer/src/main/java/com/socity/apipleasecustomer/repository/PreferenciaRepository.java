package com.socity.apipleasecustomer.repository;

import java.util.List;

import com.socity.apipleasecustomer.model.Preferencias;

public interface PreferenciaRepository {
	
public List<Preferencias> exibirPreferencias();
	
	public Preferencias exibirPreferencia();
	
	public Long consultaPreferenciaPorNome(Long idpreferencia);
	
	public Preferencias salvarPreferencia(Preferencias preferencia);
	
	public Preferencias atualizarPreferencia(Long idpreferencia, Preferencias preferencia);
	
	public void excluirPreferencia(Long idpreferencia);

}
