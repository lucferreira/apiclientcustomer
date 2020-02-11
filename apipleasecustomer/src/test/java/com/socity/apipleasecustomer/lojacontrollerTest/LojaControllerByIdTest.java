package com.socity.apipleasecustomer.lojacontrollerTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.socity.apipleasecustomer.controller.LojaController;
import com.socity.apipleasecustomer.model.Loja;
import com.socity.apipleasecustomer.service.LojaService;

public class LojaControllerByIdTest {
	
	@InjectMocks
	private LojaController lojaController;
	
	@Mock
	private LojaService lojaService;
	
	private MockMvc mockMvc;	
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(lojaController).build();
	}
	
	@Test
	public void exibirLojaPorIdTest() throws Exception {
		Loja lojaMockFalse = mock(Loja.class);
		lojaMockFalse = loja();
		Long idloja = 1L;
		
		when(lojaService.exibirLoja(idloja)).thenReturn(lojaMockFalse);
		
		mockMvc.perform(get("/loja/{idloja}",idloja)).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		.andDo(MockMvcResultHandlers.print());
		
		verify(lojaService, times(1)).exibirLoja(idloja);
		verifyNoMoreInteractions(lojaService);
	}

	public Loja loja() {
		//LocalDate localDate = LocalDate.now();
		Date data = new Date();
		Loja loja = new Loja(1L, "SUPORTE PLÁSTICO LTDA", "47583873000138", "66102483", "OBJETO", data);
		return loja;
	}
	
}
