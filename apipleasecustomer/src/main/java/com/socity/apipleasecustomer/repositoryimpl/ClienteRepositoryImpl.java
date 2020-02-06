package com.socity.apipleasecustomer.repositoryimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.socity.apipleasecustomer.model.Cliente;
import com.socity.apipleasecustomer.repository.ClienteRepository;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Cliente> exibirClientes() {
		
		return jdbcTemplate.query("SELECT * FROM CLIENTE",(rs, rowNum) -> 
		new Cliente(rs.getLong("idcliente"),rs.getString("nome"), rs.getString("cpf"),
				    rs.getString("sexo"), rs.getDate("data_nasc"), rs.getString("email")));
	}

	@Override
	public Cliente exibirCliente(Long idcliente) {
		return jdbcTemplate.queryForObject("SELECT * FROM CLIENTE CI WHERE CI.IDCLIENTE = ?", new Object[] {idcliente},
				(rs, rowNum) -> new Cliente(rs.getLong("idcliente"),rs.getString("nome"), rs.getString("cpf"),
				    rs.getString("sexo"), rs.getDate("data_nasc"), rs.getString("email")));
	}

	@Override
	public Cliente consultaClientePorNome(String nome) {
		return jdbcTemplate.queryForObject("SELECT * FROM CLIENTE CI WHERE CI.IDCLIENTE = ?", new Object[] {nome},
				(rs, rowNum) -> new Cliente(rs.getLong("idcliente"),rs.getString("nome"), rs.getString("cpf"),
					    rs.getString("sexo"), rs.getDate("data_nasc"), rs.getString("email")));
	}

	@Override
	public int salvarCliente(Cliente cliente) {
		return jdbcTemplate.update("INSERT INTO CLIENTE (nome, cpf, sexo, data_nasc, email) VALUES (?,?,?,?,?) ", cliente.getNome(), cliente.getCpf(), cliente.getSexo(),
				cliente.getData_nasc(), cliente.getEmail());
	}

	@Override
	public int atualizarCliente(Long idcliente, Cliente cliente) {
		return jdbcTemplate.update("UPDATE CLIENTE SET nome = ?, cpf = ?, sexo = ?, data_nasc = ?, email = ? WHERE idcliente = ? ", cliente.getNome(), cliente.getCpf(), cliente.getSexo(),
				cliente.getData_nasc(), cliente.getEmail(), cliente.getIdcliente());
	}

	@Override
	public int excluirCliente(Long idcliente) {
		return jdbcTemplate.update("DELETE FROM CLIENTE WHERE idcliente = ? ",
				new Object[] {idcliente});
	}

}
