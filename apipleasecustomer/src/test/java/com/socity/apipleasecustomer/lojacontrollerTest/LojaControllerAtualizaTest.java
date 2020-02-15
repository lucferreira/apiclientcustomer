package com.socity.apipleasecustomer.lojacontrollerTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.socity.apipleasecustomer.controller.LojaController;
import com.socity.apipleasecustomer.model.Loja;
import com.socity.apipleasecustomer.service.LojaService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LojaControllerAtualizaTest {
	
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
	public void atualizaLojaTest() throws Exception {
		Loja lojaMockFalse = mock(Loja.class);
		Long idloja = 1L;
		
		lojaMockFalse = loja();
		
		when(lojaService.exibirLoja(idloja)).thenReturn(lojaMockFalse);
		when(lojaService.atualizarLoja(lojaMockFalse)).thenReturn(lojaMockFalse);
		
		mockMvc.perform(put("/loja/alterloja/{idloja}", idloja)
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJson(lojaMockFalse)))
				.andExpect(status().isOk());
		
		verify(lojaService, times(1)).exibirLoja(idloja);
		verify(lojaService, times(1)).atualizarLoja(lojaMockFalse);
		verifyNoMoreInteractions(lojaService);
		
		
	}
	
	public Loja loja() {
		Date data = new Date();
		Loja loja = new Loja(1L,"ESPORTE E CIA LTDA","47583873000138","66102483","ESPORTE",data);
		return loja;
	}
	
	public String asJson(final Object ob) {
		try {
			return new ObjectMapper().writeValueAsString(ob);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

}
