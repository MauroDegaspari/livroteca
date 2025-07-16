package com.maurodegaspari.livroteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

	@Transactional(readOnly = true)
	public CategoriaModel findById(int id) {
		Optional<CategoriaModel> categorias = repo.findById(id);

		return categorias.orElseThrow(() -> new NotFoundException(" Categoria de ID: " + id + " não encontrado!"));
	}

	@Transactional(readOnly = true)
	public List<CategoriaModel> findAll() {

		return repo.findAll();
	}

	@Modifying
	@Transactional()
	public CategoriaDto criarCategoria(CategoriaDto criar) {
		CategoriaModel model = conversao.dtoParaModel(criar);
		repo.save(model);

		return conversao.modelParaDto(model);
	}

	@Modifying
	@Transactional
	public CategoriaDto alterarCartegoria(int id, CategoriaDto body) {
		CategoriaModel model = conversao.dtoParaModel(body);
		model = findById(id);
		model.setNome(body.getNome());
		model.setTexto(body.getTexto());

		repo.save(model);
		return conversao.modelParaDto(model);
	}

	@Modifying
	@Transactional()
	public void deleteCategoria(int id) {
		CategoriaModel model = findById(id);
		try {
			repo.delete(model);

		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Categoria não pode ser EXCLIUDA, possui livros cadastrados.");
		}

	}
	
}
