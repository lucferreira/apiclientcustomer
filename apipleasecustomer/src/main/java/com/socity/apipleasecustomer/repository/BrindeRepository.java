package com.socity.apipleasecustomer.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.socity.apipleasecustomer.model.Brinde;

@Repository
public interface BrindeRepository {
	
	public List<Brinde> exibirBrindes();
	
	public Brinde exibirBrinde();
	
	public Long consultaBrindePorNome(Long idbrinde);
	
	public Brinde salvarBrinde(Brinde brinde);
	
	public Brinde atualizarBrinde(Long idbrinde, Brinde brinde);
	
	public void excluirBrinde(Long idbrinde);
	
	

}
