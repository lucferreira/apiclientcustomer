package com.socity.apipleasecustomer.lojacontrollerTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.socity.apipleasecustomer.controller.LojaController;
import com.socity.apipleasecustomer.model.Loja;
import com.socity.apipleasecustomer.service.LojaService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LojaControllerExibirTodosTest {
	
	@Mock
	private LojaService lojaService;
	
	@InjectMocks
	private LojaController lojaController;
	
	private MockMvc mockMvc;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(lojaController).build();
	}
	
	@Test
	public void exibirTodasAsLojasCadastradasTest() throws Exception {
		@SuppressWarnings("unchecked")
		List<Loja> mockLojaFalso = mock(List.class);
		mockLojaFalso = lojas();
		when(lojaService.listarTodosLojas()).thenReturn(mockLojaFalso);
		
		mockMvc.perform(get("/loja/todos")).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		.andDo(MockMvcResultHandlers.print());
		
		verify(lojaService, times(1)).listarTodosLojas();
	    verifyNoMoreInteractions(lojaService);
		
	}
	
	public List<Loja> lojas(){
		//LocalDate localDate = LocalDate.now();
		Date data = new Date();
		Loja l1 = new Loja(1L, "ESPORTE FANTÁSTICO LTDA", "47583873000138", "66102483", "ESPORTE", data);
		Loja l2 = new Loja(2L, "CINEMA PARADISO LTDA", "47583873000138", "66102483", "CINEMA", data);
		Loja l3 = new Loja(3L, "CASA DE DOCES LTDA", "47583873000138", "66102483", "DOCES", data);
		List<Loja> lojas = new ArrayList<>();
		lojas.add(l1);
		lojas.add(l2);
		lojas.add(l3);
		return lojas;
	}

}
