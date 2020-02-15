package com.socity.apipleasecustomer.preferenciacontrollerTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.socity.apipleasecustomer.controller.PreferenciaController;
import com.socity.apipleasecustomer.model.Preferencias;
import com.socity.apipleasecustomer.service.PreferenciaService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PreferenciaControllerExibirTodosTest {
	
	@Mock
	private PreferenciaService preferenciaService;
	
	@InjectMocks
	private PreferenciaController preferenciaController;
	
	private MockMvc mockMvc;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(preferenciaController).build();
	}
	
	@Test
	public void exibirTodosTest() throws Exception {
		@SuppressWarnings("unchecked")
		List<Preferencias> preferenciasMockFalse = mock(List.class);
		preferenciasMockFalse = preferencias();
		when(preferenciaService.listarTodosPreferencias()).thenReturn(preferenciasMockFalse);
		mockMvc.perform(get("/preferencias/todos")
		.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		
		verify(preferenciaService, times(1)).listarTodosPreferencias();
		verifyNoMoreInteractions(preferenciaService);
	}
	
	public List<Preferencias> preferencias(){
		
		Preferencias p1 = new Preferencias(1L,"ESPORTE","Destinado a esportes em geral.");
		Preferencias p2 = new Preferencias(2L,"CINEMA","Destinado a filmes em geral.");
		Preferencias p3 = new Preferencias(3L,"ALIMENTICIO","Destinado a alimenticio em geral.");
		Preferencias p4 = new Preferencias(4L,"FITNESS","Destinado a fitness em geral.");
		Preferencias p5 = new Preferencias(5L,"TECNOLOGIA","Destinado a tecnologia em geral.");
		Preferencias p6 = new Preferencias(6L,"CARRO","Destinado a carro em geral.");
		
		List<Preferencias> preferencias = new ArrayList<>();
		preferencias.add(p1);
		preferencias.add(p2);
		preferencias.add(p3);
		preferencias.add(p4);
		preferencias.add(p5);
		preferencias.add(p6);
		
		return preferencias;
	}

}
