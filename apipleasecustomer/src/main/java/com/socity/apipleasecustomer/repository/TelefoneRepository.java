package com.socity.apipleasecustomer.repository;

import java.util.List;

import com.socity.apipleasecustomer.model.Telefone;

public interface TelefoneRepository {

	public List<Telefone> exibirTelefones();

	public Telefone exibirTelefone();

	public Long consultaTelefonePorNome(Long idtelefone);

	public Telefone salvarTelefone(Telefone telefone);

	public Telefone atualizarTelefone(Long idtelefone, Telefone brinde);

	public void excluirTelefone(Long idtelefone);

}
