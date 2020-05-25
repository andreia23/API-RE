package com.desafio.APIR.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.ForeignKey;

@Entity
public class Produto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idpro;
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name= "id_categoria", nullable = false)
	@ForeignKey(name="produto_categoria_fkey")
	private Categoria id_categoria;
	


	public Produto() {
		super();
	}


//	public Produto(Integer idpro, String descricao) {
//		super();
//		this.idpro = idpro;
//		this.descricao = descricao;
//	}


	public Produto(Integer idpro, String descricao, Categoria id_categoria) {
		super();
		this.idpro = idpro;
		this.descricao = descricao;
		this.id_categoria = id_categoria;
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
	

	
	public Categoria getId_categoria() {
		return id_categoria;
	}


	public void setId_categoria(Categoria id_categoria) {
		this.id_categoria = id_categoria;
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
