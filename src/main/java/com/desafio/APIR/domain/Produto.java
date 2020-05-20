package com.desafio.APIR.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Produto")
public class Produto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPro;
	private String descricao;
	
	@ManyToOne
    @JoinColumn(name = "idCat")
	private Categoria id_categoria;	

	
	public Produto() {
	
	}

	public Produto(Integer idPro, Categoria id_categoria, String descricao) {
		super();
		this.idPro = idPro;
		this.id_categoria = id_categoria;
		this.descricao = descricao;
	}

	public Integer getIdPro() {
		return idPro;
	}

	public void setIdPro(Integer idPro) {
		this.idPro = idPro;
	}

	public Categoria getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Categoria id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getDecricao() {
		return descricao;
	}

	public void setDecricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPro == null) ? 0 : idPro.hashCode());
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
		if (idPro == null) {
			if (other.idPro != null)
				return false;
		} else if (!idPro.equals(other.idPro))
			return false;
		return true;
	}
	
	
	
}
