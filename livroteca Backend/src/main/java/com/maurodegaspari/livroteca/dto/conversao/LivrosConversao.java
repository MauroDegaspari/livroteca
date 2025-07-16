package com.maurodegaspari.livroteca.dto.conversao;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.maurodegaspari.livroteca.dto.LivrosDto;
import com.maurodegaspari.livroteca.model.LivrosModel;

@Component
public class LivrosConversao {
	
	public LivrosDto modelparaDto(LivrosModel model) {
		LivrosDto dto = new LivrosDto();
		BeanUtils.copyProperties(model, dto);
		return dto;
	}
	
	public LivrosModel dotParaModel( LivrosDto dto) {
		LivrosModel model = new  LivrosModel();
		BeanUtils.copyProperties(dto, model);
		if (model.getCategoria() == null)
			model.setCategoria(dto.getCategoria_id());
		return model;
	}

}
