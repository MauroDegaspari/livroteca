package com.maurodegaspari.livroteca.dto;

import com.maurodegaspari.livroteca.model.CategoriaModel;

public class CategoriaDto {

	private int idDto;
	private String nomeDto;
	private String textoDto;
	
	public CategoriaDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoriaDto(CategoriaModel obj) {
		super();
		this.idDto = obj.getId();
		this.nomeDto = obj.getNome();
		this.textoDto = obj.getTexto();
	}

	public int getIdDto() {
		return idDto;
	}

	public void setIdDto(int idDto) {
		this.idDto = idDto;
	}

	public String getNomeDto() {
		return nomeDto;
	}

	public void setNomeDto(String nomeDto) {
		this.nomeDto = nomeDto;
	}

	public String getTextoDto() {
		return textoDto;
	}

	public void setTextoDto(String textoDto) {
		this.textoDto = textoDto;
	}
	
	
	
    
	
}
