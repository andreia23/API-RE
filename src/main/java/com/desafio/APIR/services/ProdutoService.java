package com.desafio.APIR.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.APIR.domain.Produto;
import com.desafio.APIR.exception.ResourceNotFoundException;
import com.desafio.APIR.repositories.ProdutoRepository;

@Service
public class ProdutoService implements Services{

	@Autowired
	private ProdutoRepository ProdutoRepository;

	@Override
	public Produto createProduto(Produto Produto) {
		return ProdutoRepository.save(Produto );
	}

	@Override
	public Produto updateProduto(Produto Produto) {
	Optional<Produto > ProdutoDb = this.ProdutoRepository.findById(Produto.getIdpro());
		
		if(ProdutoDb.isPresent()) {
			Produto  ProdutoUpdate = ProdutoDb.get();
			ProdutoUpdate.setDescricao(Produto.getDescricao());
			ProdutoUpdate.setId_categoria(Produto.getId_categoria());
			ProdutoRepository.save(ProdutoUpdate);
			return ProdutoUpdate;
			
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + Produto.getIdpro());
		}
	}

	@Override
	public List<Produto> TodosProduto() {
		return this.ProdutoRepository.findAll();
	}

	@Override
	public Produto ProdutoPorID(Integer produtoId) {
	Optional<Produto> ProdutoDb = this.ProdutoRepository.findById(produtoId);
		
		if(ProdutoDb.isPresent()) {
			return ProdutoDb.get();
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + produtoId);
		}
	}

	@Override
	public void deleteProduto(Integer ProdutoId) {
		Optional<Produto > ProdutoDb = this.ProdutoRepository.findById(ProdutoId);
		
		if(ProdutoDb.isPresent()) {
			this.ProdutoRepository.delete(ProdutoDb.get());
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + ProdutoId);
		}
		
	}
	

}