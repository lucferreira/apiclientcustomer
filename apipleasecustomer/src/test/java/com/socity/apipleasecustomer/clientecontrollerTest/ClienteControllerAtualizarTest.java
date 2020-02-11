package com.socity.apipleasecustomer.clientecontrollerTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socity.apipleasecustomer.controller.ClienteController;
import com.socity.apipleasecustomer.model.Cliente;
import com.socity.apipleasecustomer.service.ClienteService;
import com.socity.apipleasecustomer.util.Sexo;

public class ClienteControllerAtualizarTest {
	
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
	public void atualizarClienteTest() throws Exception {
		Cliente clienteMockFalse = mock(Cliente.class);
		clienteMockFalse = cliente();
		Long idcliente = cliente().getIdcliente();
		
		when(clienteService.atualizarCliente(idcliente, clienteMockFalse)).thenReturn(clienteMockFalse);
		mockMvc.perform(put("/cliente/altercliente/{idcliente}", idcliente)
		.contentType(MediaType.APPLICATION_JSON)
		.content(asJsonString(clienteMockFalse)))
		.andExpect(status().isOk());
		
	}
	
	public Cliente cliente () {
		//LocalDate localDate = LocalDate.now();
		Date data = new Date();
		Cliente cl = new Cliente(1L,"Márcio Levi Souza","930.021.057-24",Sexo.MASCULINO,data,"mmario@mnproducoes.com");
		return cl;
	}
	
	public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
