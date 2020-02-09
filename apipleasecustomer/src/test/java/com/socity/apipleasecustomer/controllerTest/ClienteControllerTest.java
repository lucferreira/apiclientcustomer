package com.socity.apipleasecustomer.controllerTest;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.socity.apipleasecustomer.controller.ClienteController;
import com.socity.apipleasecustomer.model.Cliente;
import com.socity.apipleasecustomer.service.ClienteService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ClienteControllerTest {
	
	@Mock
	private ClienteService clienteService;
	
	@InjectMocks
	private ClienteController clienteController;
	
	private MockMvc mockMvc;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(clienteController).build();
		
	}
	@Test
	public void exibirTodosOsClientes() throws Exception {
		
		when(clienteService.listarTodosClientes()).thenReturn(clientes());
		mockMvc.perform(get("/clientes")).andExpect(status().isOk());
		
		verify(clienteService, times(1)).listarTodosClientes();
	    verifyNoMoreInteractions(clienteService);
		
	}
	
	public List<Cliente> clientes(){
		List<Cliente> clientes = new ArrayList<>();
		Cliente cl1 = new Cliente(1L,"Márcio Levi Souza","930.021.057-24","MASCULINO",LocalDate.now(),"mmariosouza@mnproducoes.com");
		Cliente cl2 = new Cliente(1L,"Roberto Levi Souza","930.021.057-24","MASCULINO",LocalDate.now(),"mmariosouza@mnproducoes.com");
		Cliente cl3 = new Cliente(1L,"Carlos Levi Souza","930.021.057-24","MASCULINO",LocalDate.now(),"mmariosouza@mnproducoes.com");
		clientes.add(cl1);
		clientes.add(cl2);
		clientes.add(cl3);
		return clientes;
	}

}
