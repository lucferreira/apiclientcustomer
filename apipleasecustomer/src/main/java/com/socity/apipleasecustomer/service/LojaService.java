package com.socity.apipleasecustomer.service;

import java.util.List;

import com.socity.apipleasecustomer.model.Loja;

public interface LojaService {

	public List<Loja> listarTodosLojas();

	public Loja exibirLoja(Long idloja);

	public Loja salvarLoja(Loja loja);

	public Loja atualizarLoja(Long idloja, Loja loja);

	public Loja deletarCliente(Long idloja);

}
