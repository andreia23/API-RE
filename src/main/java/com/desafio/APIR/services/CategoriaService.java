package com.desafio.APIR.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.APIR.domain.Categoria;
import com.desafio.APIR.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository CategoriaRepo ;

	public Categoria buscarPorId(Integer id) {
	    Optional<Categoria> obj = CategoriaRepo.findById(id);
	    return obj.orElse(null);
	}

}