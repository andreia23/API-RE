package com.desafio.APIR.controller;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

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
	
	//@Autowired
	//private CategoriaService CategoriaService;
	
	@ApiOperation(value="Retorna uma lista de produtos")
	@GetMapping(produces="application/json")
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
	
	@ApiOperation(value="Retorna um produto específico")
	@GetMapping(value="/{idpro}",produces="application/json")
	public String getProdutoById(@PathVariable Integer idpro){
		Produto retorno = ProdutoService.ProdutoPorID(idpro);
	    JSONObject my_json = new JSONObject();
	    my_json.put("IdPro", retorno.getIdpro());
	    my_json.put("Descrição",retorno.getDescricao());
	    my_json.put("Categoria",retorno.getId_categoria().getCategoria());
		return my_json.toString();
	}
	
	
	@ApiOperation(value="Salva um produto")
	@PostMapping()
	public Produto createProduto(@RequestBody Produto produto){
		//Categoria cat2 = new Categoria(null,"Roupas");
		//CategoriaService.createCategoria(cat2);
		//Produto p2 = new Produto(null,"Vestido",cat2);
		return ProdutoService.createProduto(produto);
		
	}
	
	@ApiOperation(value="Altera um produto")
	@PutMapping("/{id}")
	public ResponseEntity<Produto> updateProduto(@PathVariable Integer id,@RequestBody Produto produto){
		produto.setIdpro(id);;
		//Categoria cat2 = new Categoria(null,"Informatica");
		//CategoriaService.createCategoria(cat2);
		//Produto p2 = new Produto(id,"Computador",cat2);
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
		//File file1 = new File("../teste2");
		//String tipo = "pdf";
		LocalDateTime date_time = LocalDateTime.now();
	    String file_name = file.getName();
	    JSONObject my_obj = new JSONObject();
	    my_obj.put("file_name", file_name+"."+ file_type );
	    my_obj.put("date_time", date_time);
	    my_obj.put("status", "VALID");
	    
		return my_obj.toString();
		
	}

}
