package com.desafio.APIR.controller;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.APIR.domain.Produto;
import com.desafio.APIR.services.ProdutoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value="API REST Produtos")
@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	 
	@Autowired
	private ProdutoService ProdutoService;
	
	
	@ApiOperation(value="Retorna uma lista de produtos")
	@GetMapping(produces="application/json")
	public List<Produto> getAllProduto(){
		return  ProdutoService.TodosProduto();
	}
	
	@ApiOperation(value="Retorna um produto específico")
	@GetMapping(value="/{idpro}",produces="application/json")
	public ResponseEntity<Produto> getProdutoById(@PathVariable Integer idpro){
		return ResponseEntity.ok().body(this.ProdutoService.ProdutoPorID(idpro));
	
	}
	
	@ApiOperation(value="Salva um produto")
	@PostMapping()
	public ResponseEntity<Produto> createProduto(@RequestBody Produto produto){
		return ResponseEntity.ok().body(this.ProdutoService.createProduto(produto));
		
	}
	
	@ApiOperation(value="Altera um produto")
	@PutMapping("/{id}")
	public ResponseEntity<Produto> updateProduto(@PathVariable Integer id,@RequestBody Produto produto){
		produto.setIdpro(id);
		return ResponseEntity.ok().body(this.ProdutoService.updateProduto(produto));
		
	}
	
	@ApiOperation(value="Deleta um produto")
	@DeleteMapping("/{id}")
	public HttpStatus deleteProduto(@PathVariable Integer id){
		this.ProdutoService.deleteProduto(id);
		return HttpStatus.OK;
		
	}
	
	@ApiOperation(value="Simular validação de arqivo")
	@GetMapping(value="/validacao",produces="application/json")
	public String arquivo(String file_type, File file){
		LocalDateTime date_time = LocalDateTime.now();
	    	String file_name = file.getName();
	    	JSONObject my_obj = new JSONObject();
	    	my_obj.put("file_name", file_name+"."+ file_type );
	    	my_obj.put("date_time", date_time);
	    	my_obj.put("status", "VALID");
		return my_obj.toString();
		
	}

}
