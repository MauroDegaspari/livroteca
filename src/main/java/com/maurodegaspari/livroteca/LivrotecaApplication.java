package com.maurodegaspari.livroteca;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.maurodegaspari.livroteca.domain.CategoriaModel;
import com.maurodegaspari.livroteca.domain.LivrosModel;
import com.maurodegaspari.livroteca.repositories.CategoriaRepository;
import com.maurodegaspari.livroteca.repositories.LivroRepository;

@SpringBootApplication
public class LivrotecaApplication implements CommandLineRunner{
	
	@Autowired
	CategoriaRepository repoCate;
	LivroRepository repoLivro;
	
	public static void main(String[] args) {
		SpringApplication.run(LivrotecaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		
		CategoriaModel informatica = new CategoriaModel(0, "Informática", "Livros de informática");
		CategoriaModel ficcaoCientifica = new CategoriaModel(0, "Ficção Científica", "Livros de Ficção Científica");
		CategoriaModel comedia = new CategoriaModel(0, "Comedia", "Livros de comédia");
		
		LivrosModel l1 = new LivrosModel(0, "Infortudo", "PessoaTal", "Lorem ipsum", informatica);
		LivrosModel l2 = new LivrosModel(0, "The time Machine", "escritor de fora", "Lorem ipsum", informatica);
		LivrosModel l3 = new LivrosModel(0, "Engeraneia infformatica", "PessoaTal", "Lorem ipsum", informatica);
		LivrosModel l4 = new LivrosModel(0, "Só rindo", "Sicrano", "Lorem ipsum", informatica);
		LivrosModel l5 = new LivrosModel(0, "I, Robot", "Fulano", "Lorem ipsum", informatica);
		
		informatica.getLivro().addAll(Arrays.asList(l1,l3));
		ficcaoCientifica.getLivro().addAll(Arrays.asList(l1, l5));
		comedia.getLivro().addAll(Arrays.asList(l4));
		
		repoCate.saveAll(Arrays.asList(informatica, ficcaoCientifica,comedia));
		repoLivro.saveAll(Arrays.asList(l1,l2,l3,l4,l5));
		
		
		
		
		
		
		
		
		
		
	}

}
