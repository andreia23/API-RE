package com.desafio.APIR.controller;


import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public String getAllProduto(){
		List<Produto> produtos = ProdutoService.TodosProduto();
		JSONArray allDataArray = new JSONArray();
		for(int index = 0; index < produtos.size(); index++) {
            JSONObject eachData = new JSONObject();
            eachData.put("IdPro", produtos.get(index).getIdpro());
            eachData.put("Categoria", produtos.get(index).getId_categoria().getCategoria());
            eachData.put("Descricão", produtos.get(index).getDescricao());
            allDataArray.put(eachData);
		}

		return allDataArray.toString();
	}
	
	@GetMapping("/produtos/{idpro}")
	public String getProdutoById(@PathVariable Integer idpro){
		Produto retorno = ProdutoService.ProdutoPorID(idpro);
	    JSONObject my_json = new JSONObject();
	    my_json.put("IdPro", retorno.getIdpro());
	    my_json.put("Descrição",retorno.getDescricao());
	    my_json.put("Categoria",retorno.getId_categoria().getCategoria());
		return my_json.toString();
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
	
	@GetMapping("/arquivo")
	public String arquivo(){

		File file = new File("../Teste.pdf");
		LocalDateTime date_time = LocalDateTime.now();
	    String file_name = file.getName();
	    
	    JSONObject my_obj = new JSONObject();
	    my_obj.put("file_name", file_name );
	    my_obj.put("date_time", date_time);
	    
		return my_obj.toString();
		
		
	}
	
}
