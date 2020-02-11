package com.socity.apipleasecustomer.lojacontrollerTest;

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
import com.socity.apipleasecustomer.controller.LojaController;
import com.socity.apipleasecustomer.model.Loja;
import com.socity.apipleasecustomer.service.LojaService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LojaControllerNovoTest {
	
	
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
	public void incluirNovaLojaTest() throws Exception {
		Loja lojaMockFalse = mock(Loja.class);
		lojaMockFalse = loja();
		
		when(lojaService.salvarLoja(lojaMockFalse)).thenReturn(lojaMockFalse);
		mockMvc.perform(post("/loja/novo")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(lojaMockFalse)))
				.andExpect(status().isOk());
		
		verify(lojaService, times(1)).salvarLoja(lojaMockFalse);
		
	}

	public Loja loja() {
		//LocalDate localDate = LocalDate.now();
		Date data = new Date();
		Loja loja = new Loja(1L, "SUPORTE PLÁSTICO LTDA", "47583873000138", "66102483", "OBJETO", data);
		return loja;
	}
	
	public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	
}
