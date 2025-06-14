package com.maurodegaspari.livroteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maurodegaspari.livroteca.exceptions.NotFoundException;
import com.maurodegaspari.livroteca.model.CategoriaModel;
import com.maurodegaspari.livroteca.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository repo;
	
	public CategoriaModel findById(int id) {
		Optional<CategoriaModel> categorias = repo.findById(id);
		
		return categorias.orElseThrow(() -> new NotFoundException(" Objeto não encontrado!" + id + ", tipo: " + categorias.getClass().getName()));
	}
	
	public List<CategoriaModel> findAll() {
		return repo.findAll();
	}
	
}
