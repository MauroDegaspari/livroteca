package com.maurodegaspari.livroteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maurodegaspari.livroteca.dto.CategoriaDto;
import com.maurodegaspari.livroteca.dto.conversao.CategoriaConversao;
import com.maurodegaspari.livroteca.exceptions.NotFoundException;
import com.maurodegaspari.livroteca.model.CategoriaModel;
import com.maurodegaspari.livroteca.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository repo;

	@Autowired
	CategoriaConversao conversao;

	public CategoriaModel findById(int id) {
		Optional<CategoriaModel> categorias = repo.findById(id);

		return categorias.orElseThrow(() -> new NotFoundException(
				" Objeto não encontrado!" + id + ", tipo: " + categorias.getClass().getName()));
	}

	public List<CategoriaModel> findAll() {

		return repo.findAll();
	}

	@Modifying
	@Transactional()
	public CategoriaDto criarCategoria(CategoriaDto criar) {
		CategoriaModel model = conversao.dtoParaModel(criar);

		model.setId(0);
		repo.save(model);
	
		return conversao.modelParaDto(model);
	}

}
