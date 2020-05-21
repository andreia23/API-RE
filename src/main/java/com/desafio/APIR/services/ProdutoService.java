package com.desafio.APIR.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.APIR.domain.Produto;
import com.desafio.APIR.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	

	@Autowired
	private ProdutoRepository produtoRepo ;
	
	public Produto find_Id(Integer id) {
		Optional<Produto> obj = produtoRepo.findById(id);
	    return obj.orElse(null);
	}
	
	public List<Produto> todosOsProdutos() {
    	List<Produto> listProduto = produtoRepo.findAll();
	        return listProduto;
	}
	
	public void inserirProduto() {
		Produto p1 = new Produto(null,"Suco");
		produtoRepo.saveAll(Arrays.asList(p1));
		
	}
}