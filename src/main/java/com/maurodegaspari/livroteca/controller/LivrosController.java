package com.maurodegaspari.livroteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maurodegaspari.livroteca.dto.LivrosDto;
import com.maurodegaspari.livroteca.services.LivrosServices;

@RestController
@RequestMapping(value = "/livros")
public class LivrosController {

	@Autowired
	private LivrosServices service;

	@GetMapping(value = "{id}")
	public ResponseEntity<LivrosDto> acharPorId(@PathVariable int id) {
		return service.findById(id).map(mapearObj -> ResponseEntity.ok().body(mapearObj))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping
	public ResponseEntity<List<LivrosDto>> todosLivros(@RequestParam(value = "categoria", defaultValue= "0") int id){
		List<LivrosDto> livrosCategoria = service.todosLivrosCategoria(id);
		return ResponseEntity.ok().body(livrosCategoria);	}
}
