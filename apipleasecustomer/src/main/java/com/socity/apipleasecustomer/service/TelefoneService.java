package com.socity.apipleasecustomer.service;

import java.util.List;

import com.socity.apipleasecustomer.model.Telefone;

public interface TelefoneService {

	public List<Telefone> listarTodosTelefones();

	public Telefone exibirTelefone(Long idtelefone);

	public Telefone salvarTelefone(Telefone telefone);

	public Telefone atualizarTelefone(Long idtelefone, Telefone telefone);

	public Telefone deletarTelefone(Long idtelefone);

}
