package com.maurodegaspari.livroteca.dto.conversao;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.maurodegaspari.livroteca.dto.CategoriaDto;
import com.maurodegaspari.livroteca.model.CategoriaModel;

@Component
public class CategoriaConversao {

	public CategoriaDto modelParaDto(CategoriaModel model) {
		CategoriaDto dto = new CategoriaDto();
		BeanUtils.copyProperties(model, dto);
		return dto;
	}
	
	
	public CategoriaModel dtoParaModel(CategoriaDto dto) {
		System.out.println("dtoParaModel:" +dto.getId()+" nome: "+ dto.getNome()+" texto:"+ dto.getTexto());
		CategoriaModel model = new CategoriaModel();
		BeanUtils.copyProperties(dto, model);
		System.out.println("dtoParaModel2:" +model.getId()+" nome: "+ model.getNome()+" texto:"+ model.getTexto());
		return model;
	}
}
