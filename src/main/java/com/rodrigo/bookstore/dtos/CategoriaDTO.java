package com.rodrigo.bookstore.dtos;

import java.io.Serializable;

import com.rodrigo.bookstore.domain.Categoria;

public class CategoriaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String descricao;
	
	public CategoriaDTO() {
		super();
	}
	
	public CategoriaDTO(Categoria obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.descricao = obj.getDescricao();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
