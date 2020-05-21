package com.desafio.APIR.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.APIR.domain.Produto;
import com.desafio.APIR.services.ProdutoService;

@RestController
@RequestMapping(value="/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Produto> buscarLivros() {
		return service.todosOsProdutos();
		
	}
	
	@RequestMapping(value = "/{idpro}",method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer idpro){
		Produto p1 = service.find_Id(idpro);
		return ResponseEntity.ok().body(p1);
	}
	 
	
	
	@RequestMapping(value = "/inserir",method = RequestMethod.GET)
	public String inserir() {
		service.inserirProduto();
		return "Salvo";
	}
	
}
