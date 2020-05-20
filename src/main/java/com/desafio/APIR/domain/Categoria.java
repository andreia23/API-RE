package com.desafio.APIR.domain;

import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Categoria")
public class Categoria implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCat;
	private String categoria;

//	private List<Produto> produtos = new ArrayList<>();	
	
	public  Categoria() {
		
	}

	public Categoria(Integer id, String categoria) {
		super();
		this.idCat = id;
		this.categoria = categoria;
	}

	public Integer getId() {
		return idCat;
	}

	public void setId(Integer id) {
		this.idCat = id;
	}

	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

//	public List<Produto> getProdutos() {
//		return produtos;
//	}
//
//	public void setProdutos(List<Produto> produtos) {
//		this.produtos = produtos;
//	}

	

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCat == null) ? 0 : idCat.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (idCat == null) {
			if (other.idCat != null)
				return false;
		} else if (!idCat.equals(other.idCat))
			return false;
		return true;
	}
	
	
}
