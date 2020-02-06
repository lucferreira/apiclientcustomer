package com.socity.apipleasecustomer.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.socity.apipleasecustomer.model.Loja;

@Repository
public interface LojaRepository {
	
public Loja exibirCliente();
	
	public List<Loja> exibirLojas();

	public Loja exibirLoja();

	public Long consultaLojaPorNome(Long idloja);
	
	public Loja salvarLoja(Loja loja);
	
	public Loja atualizarLoja(Long idloja, Loja loja);
	
	public void excluirLoja(Long idloja);

}
