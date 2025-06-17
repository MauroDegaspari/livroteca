package com.maurodegaspari.livroteca.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maurodegaspari.livroteca.dto.CategoriaDto;
import com.maurodegaspari.livroteca.model.CategoriaModel;
import com.maurodegaspari.livroteca.services.CategoriaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaController {

	@Autowired
	CategoriaService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoriaModel> acharId(@PathVariable int id) {

		CategoriaModel obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<CategoriaDto>> findAl() {
		List<CategoriaModel> list = service.findAll();
		List<CategoriaDto> listDto = list.stream().map(obj -> new CategoriaDto(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDto);
	}

	@PostMapping(value = "/criarCategoria")
	public ResponseEntity<CategoriaDto>  saveCategoria(@Valid @RequestBody CategoriaDto body) {
		CategoriaDto newCategoria = service.criarCategoria(body);
		
		return ResponseEntity.ok().body(newCategoria);

	}

}
