package com.socity.apipleasecustomer.clientecontrollerTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socity.apipleasecustomer.controller.ClienteController;
import com.socity.apipleasecustomer.model.Cliente;
import com.socity.apipleasecustomer.service.ClienteService;
import com.socity.apipleasecustomer.util.Sexo;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ClienteControllerNovoTest {
	
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
	public void inserirNovoClienteTest() throws Exception {
		Cliente mockCliente = mock(Cliente.class);
		mockCliente = cliente();
		
		when(clienteService.salvarCliente(mockCliente)).thenReturn(mockCliente);
		mockMvc.perform(post("/cliente/novo")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(mockCliente)))
				.andExpect(status().isOk());
		
		verify(clienteService, times(1)).salvarCliente(mockCliente);
	}
	
	public Cliente cliente () {
		//LocalDate localDate = LocalDate.now();
		Date data = new Date();
		Cliente cl = new Cliente(5L,"Márcio Levi Souza","930.021.057-24",Sexo.MASCULINO,data,"mmario@mnproducoes.com");
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
