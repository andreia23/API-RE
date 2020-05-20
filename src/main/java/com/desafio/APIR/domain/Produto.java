package com.desafio.APIR.domain;

public class Produto {
	private Integer idPro;
	private Categoria id_categoria;	
	private String decricao;
	
	public Produto() {
	
	}

	public Produto(Integer idPro, Categoria id_categoria, String decricao) {
		super();
		this.idPro = idPro;
		this.id_categoria = id_categoria;
		this.decricao = decricao;
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
		return decricao;
	}

	public void setDecricao(String decricao) {
		this.decricao = decricao;
	}
	
	
	
}
