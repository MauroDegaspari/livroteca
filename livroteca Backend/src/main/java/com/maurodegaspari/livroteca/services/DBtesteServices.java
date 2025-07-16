package com.maurodegaspari.livroteca.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maurodegaspari.livroteca.model.CategoriaModel;
import com.maurodegaspari.livroteca.model.LivrosModel;
import com.maurodegaspari.livroteca.repositories.CategoriaRepository;
import com.maurodegaspari.livroteca.repositories.LivrosRepository;

@Service
public class DBtesteServices {
	
	@Autowired
	CategoriaRepository repoCate;
	
	@Autowired
	LivrosRepository repoLivro;
	
	public void insertBancoTest() {

	CategoriaModel informatica = new CategoriaModel(0, "Informática", "Livros de informática");
	CategoriaModel ficcaoCientifica = new CategoriaModel(0, "Ficção Científica", "Livros de Ficção Científica");
	CategoriaModel comedia = new CategoriaModel(0, "Comedia", "Livros de comédia");

	LivrosModel l1 = new LivrosModel(0, "Infortudo", "PessoaTal", "Lorem ipsum", informatica);
	LivrosModel l2 = new LivrosModel(0, "The time Machine", "escritor de fora", "Lorem ipsum", ficcaoCientifica);
	LivrosModel l3 = new LivrosModel(0, "Engeraneia infformatica", "PessoaTal", "Lorem ipsum", informatica);
	LivrosModel l4 = new LivrosModel(0, "Só rindo", "Sicrano", "Lorem ipsum", comedia);
	LivrosModel l5 = new LivrosModel(0, "I, Robot", "Fulano", "Lorem ipsum", ficcaoCientifica);
	
	informatica.getLivro().addAll(Arrays.asList(l1));
	ficcaoCientifica.getLivro().addAll(Arrays.asList(l2, l5));
	comedia.getLivro().addAll(Arrays.asList(l4));
	
	repoCate.saveAll(Arrays.asList(informatica,ficcaoCientifica,comedia));
	repoLivro.saveAll(Arrays.asList(l1,l2,l3,l4,l5));
	}
}
