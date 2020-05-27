package com.desafio.APIR.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.desafio.APIR.ApiRApplication;
import com.desafio.APIR.controller.ProdutoController;
import com.desafio.APIR.domain.Categoria;
import com.desafio.APIR.domain.Produto;
import com.desafio.APIR.services.CategoriaService;


class ProdutoControllerTest extends ApiRApplication{
	
	private MockMvc mockMvc;

	@Autowired
	CategoriaService CategoriaService;
	
	@Autowired
	ProdutoController controler = new ProdutoController();
 
	@BeforeEach
	void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.standaloneSetup(controler).build();
	}
	
//	@Test
//	public void testGetAllProduto() throws Exception {
//		this.mockMvc.perform(MockMvcRequestBuilders.get("/produtos")).andExpect(MockMvcResultMatchers.status().isOk());
//	}
//
//	@Test
//	void testGetProdutoById() {
//		ResponseEntity<Produto> result = controler.getProdutoById(1);
//		assertEquals(result.getBody().getIdpro(), is(1));
//		
//	}
//
	@Test
	void testCreateProduto() {
		Categoria cat1 = new Categoria(null,"Bebidas");
		CategoriaService.createCategoria(cat1);  		
		Produto p1 = new Produto(null,"Leite");
		ProdutoController controler = new ProdutoController();
//        Produto result = controler.createProduto(p1);
        
        
//        
//		assertThat(result.getDescricao(), is("Leite"));		
	}
	
  


//	@Test
//	void testUpdateProduto() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testDeleteProduto() {
//		fail("Not yet implemented");
//	}

}
