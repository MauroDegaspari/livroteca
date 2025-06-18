package com.maurodegaspari.livroteca.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.maurodegaspari.livroteca.model.CategoriaModel;

public class CategoriaDto {

	private int id;
	private String nome;
	private String texto;
	
	public CategoriaDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoriaDto(int id, String nome, String texto) {
		super();
		this.id = id;
		this.nome = nome;
		this.texto = texto;
	}
	
	public CategoriaDto( CategoriaModel model) {
		super();
		this.id = model.getId();
		this.nome = model.getNome();
		this.texto = model.getTexto();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
    
	
}
