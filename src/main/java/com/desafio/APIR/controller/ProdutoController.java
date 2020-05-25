package com.desafio.APIR.controller;


import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.APIR.domain.Categoria;
import com.desafio.APIR.domain.Produto;
import com.desafio.APIR.services.CategoriaService;
import com.desafio.APIR.services.ProdutoService;

@RestController
public class ProdutoController {
	
	@Autowired
	private ProdutoService ProdutoService;
	

	@Autowired
	private CategoriaService CategoriaService;
	
	
	@GetMapping("/produtos")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<List<Produto>> getAllProduto(){
		return ResponseEntity.ok().body(ProdutoService.TodosProduto());
	}
	
	@GetMapping("/produtos/{idpro}")
	public ResponseEntity<Produto> getProdutoById(@PathVariable Integer idpro){
		return ResponseEntity.ok().body(ProdutoService.ProdutoPorID(idpro));
	}
	
	@GetMapping("/criar")
	public ResponseEntity<Produto> createProduto(){
		Categoria cat1 = new Categoria(null,"Bebidas");
		CategoriaService.createCategoria(cat1);
		Produto p1 = new Produto(null,"Computador",cat1);
		return ResponseEntity.ok().body(this.ProdutoService.createProduto(p1));
	}
	
	@GetMapping("/alterar/{id}")
	public ResponseEntity<Produto> updateProduto(@PathVariable Integer id){
//		Produto.setId(id);
		Categoria cat2 = new Categoria(null,"Informatica");
		CategoriaService.createCategoria(cat2);
		Produto p2 = new Produto(id,"Leite",cat2);
		return ResponseEntity.ok().body(this.ProdutoService.updateProduto(p2));
	}

	@GetMapping("/apagar/{id}")
	public HttpStatus deleteProduto(@PathVariable Integer id){
		this.ProdutoService.deleteProduto(id);
		return HttpStatus.OK;
	}
	
}
