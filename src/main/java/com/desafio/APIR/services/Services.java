package com.desafio.APIR.services;
import java.util.List;

import com.desafio.APIR.domain.Produto;

public interface Services {
	
	Produto createProduto(Produto Produto);

	Produto updateProduto(Produto Produto);

	List<Produto> TodosProduto();

	Produto ProdutoPorID(Integer produtoId);

	void deleteProduto(Integer id);


}

