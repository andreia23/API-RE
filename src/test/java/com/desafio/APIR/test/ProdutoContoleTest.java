package com.desafio.APIR.test;


/**********************************************************
 * TENTEI FAZER MAS OS TESTES NÃO ESTÃO FUNCIONANDO. 
 * POR PROBLEMA NO MEU PC NESSES DIAS NÃO DEU TEMPO CONSERTAR OS ERROS.
 **********************************************************/


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;

import com.desafio.APIR.controller.ProdutoController;
import com.desafio.APIR.domain.Categoria;
import com.desafio.APIR.domain.Produto;
import com.desafio.APIR.services.CategoriaService;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class ProdutoContoleTest {
	
	
	private CategoriaService  CategoriaService = new CategoriaService();

	private ProdutoController controle = new ProdutoController();


	@Test
	void testGetAllProduto() {
		List <Produto> produtos = controle.getAllProduto();
		assertThat(produtos).size().isGreaterThan(2);
	}

	@Test
	void testGetProdutoById() {
		Integer id = 1;
		ResponseEntity<Produto> p3 = controle.getProdutoById(id);
		assertThat(p3.getBody().getIdpro()).isEqualTo(id);
	}

	@Test
	@Rollback(false)
	void testCreateProduto() {
		Categoria cat2 = new Categoria(null,"Roupas");
		CategoriaService.createCategoria(cat2);
		Produto p2 = new Produto(null,"Vestido",cat2);
		ResponseEntity<Produto> saveProduto = controle.createProduto(p2);
		assertNotNull(saveProduto);
	}

	@Test
	@Rollback(false)
	void testUpdateProduto() {
		Categoria cat2 = new Categoria(null,"Informatica");
		CategoriaService.createCategoria(cat2);
		Produto p2 = new Produto(2,"Computador",cat2);
		controle.updateProduto(2, p2);
		ResponseEntity<Produto> pro =controle.getProdutoById(2); 
		assertThat(pro.getBody().getDescricao()).isEqualTo(p2.getDescricao());
	}

	@Test
	void testDeleteProduto() {
		Integer id = 2;
		controle.deleteProduto(id);
		assertThat("ok");
	}

	@Test
	void testArquivo() {
		fail("Not yet implemented");
	}

}
