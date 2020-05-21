package com.desafio.APIR.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idpro;
	private String descricao;
	
	
	public Produto() {
		super();
	}


	public Produto(Integer idpro, String descricao) {
		super();
		this.idpro = idpro;
		this.descricao = descricao;
	}


	public Integer getIdpro() {
		return idpro;
	}


	public void setIdpro(Integer idpro) {
		this.idpro = idpro;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((idpro == null) ? 0 : idpro.hashCode());
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
		Produto other = (Produto) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idpro == null) {
			if (other.idpro != null)
				return false;
		} else if (!idpro.equals(other.idpro))
			return false;
		return true;
	}
	
	
}
