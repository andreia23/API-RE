package com.desafio.APIR.controller;


import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
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
	public List<Produto> getAllProduto(){
		return ProdutoService.TodosProduto();
	}
	
	@Produces(MediaType.APPLICATION_JSON)
	@GetMapping("/produtos/{idpro}")
	public ResponseEntity<Produto> getProdutoById(@PathVariable Integer idpro){
		return ResponseEntity.ok().body(ProdutoService.ProdutoPorID(idpro));
	}
	
	@PostMapping("/produtos")
	public Produto createProduto(){

		Categoria cat2 = new Categoria(null,"Roupas");
		CategoriaService.createCategoria(cat2);
		Produto p2 = new Produto(null,"Vestido",cat2);
		return ProdutoService.createProduto(p2);
	}
	
	@PutMapping("/produtos/{id}")
	public ResponseEntity<Produto> updateProduto(@PathVariable Integer id){
//		Produto.setId(id);
		Categoria cat2 = new Categoria(null,"Informatica");
		CategoriaService.createCategoria(cat2);
		Produto p2 = new Produto(id,"Computador",cat2);
		return ResponseEntity.ok().body(this.ProdutoService.updateProduto(p2));
	}

	@DeleteMapping("/produtos/{id}")
	public HttpStatus deleteProduto(@PathVariable Integer id){
		this.ProdutoService.deleteProduto(id);
		return HttpStatus.OK;
	}
	
}
