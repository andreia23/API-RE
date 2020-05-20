package com.desafio.APIR.services;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.APIR.domain.Categoria;
import com.desafio.APIR.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepo ;

	public Categoria buscarPorId(Integer id) {
	    Optional<Categoria> obj = categoriaRepo.findById(id);
	    return obj.orElse(null);
	}
	
	public Categoria salvar() {
		Categoria cat1 = new Categoria(null,"informatica");
 		Categoria cat2 = new Categoria(null,"escritorio");

 		categoriaRepo.saveAll(Arrays.asList(cat1, cat2));
	    return cat2;
	}

}