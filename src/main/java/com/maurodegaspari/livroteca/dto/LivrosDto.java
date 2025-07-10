package com.maurodegaspari.livroteca.dto;

import com.maurodegaspari.livroteca.model.CategoriaModel;

public class LivrosDto {
	
	private int id;
	private String titulo;
	private String nome_autor;
	private String texto;
	private CategoriaModel categoria_id;
	
	public LivrosDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LivrosDto(int id, String titulo, String nome_autor, String texto, CategoriaModel categoria_id) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.nome_autor = nome_autor;
		this.texto = texto;
		this.categoria_id = categoria_id;
	}


	public LivrosDto(int id, String titulo, String autor) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.nome_autor = autor;
	}
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}

	public CategoriaModel getCategoria_id() {
		return categoria_id;
	}

	public void setCategoria_id(CategoriaModel categoria_id) {
		this.categoria_id = categoria_id;
	}
	
	

}
