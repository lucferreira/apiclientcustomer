package com.socity.apipleasecustomer.clientecontrollerTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.socity.apipleasecustomer.controller.ClienteController;
import com.socity.apipleasecustomer.model.Cliente;
import com.socity.apipleasecustomer.service.ClienteService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ClienteControllerByIdTest {
	
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
	public void ExibirClienteControllerPorId() throws Exception {
		Cliente mockCliente = mock(Cliente.class);
		mockCliente = cliente();
		Long idcliente = 1L;
		
		when(clienteService.exibirCliente(idcliente)).thenReturn(mockCliente);
		
		mockMvc.perform(get("/cliente/{idcliente}",idcliente)).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
		
		verify(clienteService, times(1)).exibirCliente(idcliente);
	    verifyNoMoreInteractions(clienteService);
		
	}
	
	public Cliente cliente () {
		Cliente cl = new Cliente(1L,"Márcio Levi Souza","930.021.057-24","MASCULINO",LocalDate.now(),"mmariosouza@mnproducoes.com");
		return cl;
	}

}
