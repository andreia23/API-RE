package com.desafio.APIR.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.APIR.domain.Categoria;
import com.desafio.APIR.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository CategoriaRepository;

	
	public Categoria createCategoria(Categoria Categoria) {
		return CategoriaRepository.save(Categoria);
	}

	public List<Categoria> TodasCategoria() {
		return this.CategoriaRepository.findAll();
	}
}
