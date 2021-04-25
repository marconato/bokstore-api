package com.rodrigo.bookstore.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.rodrigo.bookstore.domain.Livro;

public class LivroDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotEmpty(message = "Campo TÍTULO é requirido")
	@Length(min = 3, max = 50, message = "O campo TÍTULO deve ter entre 3 e 50 caracteres")
	private String titulo;
	
	@NotEmpty(message = "Campo NOME DO AUTOR é requirido")
	@Length(min = 3, max = 50, message = "O campo NOME DO AUTOR deve ter entre 3 e 50 caracteres")
	private String nome_autor;
	
	public LivroDTO() {
		super();
	}
	
	public LivroDTO(Livro obj) {
		super();
		this.id = obj.getId();
		this.titulo = obj.getTitulo();
		this.nome_autor = obj.getNome_autor();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getNome_autor() {
		return nome_autor;
	}
	public void setNome_autor(String nome_autor) {
		this.nome_autor = nome_autor;
	}

}
