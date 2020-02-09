package com.socity.apipleasecustomer.service;

import java.util.List;

import com.socity.apipleasecustomer.model.Brinde;

public interface BrindeService {

public List<Brinde> listarTodosBrindes();
	
	public Brinde exibirBrinde(Long idbrinde);
	
	public Brinde salvarBrinde(Brinde brinde);
	
	public Brinde atualizarBrinde(Long idbrinde, Brinde brinde);
	
}
