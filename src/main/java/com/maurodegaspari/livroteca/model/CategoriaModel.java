package com.maurodegaspari.livroteca.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "CATEGORIAS")
public class CategoriaModel {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String texto;
	
	@OneToMany(mappedBy = "categoria")
	private List<LivrosModel> livro = new ArrayList<>();
	
	public CategoriaModel() {
		super();
	}

	public CategoriaModel(int id, String nome, String texto) {
		
		this.id = id;
		this.nome = nome;
		this.texto = texto;
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

	public List<LivrosModel> getLivro() {
		return livro;
	}

	public void setLivro(List<LivrosModel> livro) {
		this.livro = livro;
	}
	
	
}
