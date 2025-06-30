package com.maurodegaspari.livroteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maurodegaspari.livroteca.dto.LivrosDto;
import com.maurodegaspari.livroteca.dto.conversao.LivrosConversao;
import com.maurodegaspari.livroteca.exceptions.NotFoundException;
import com.maurodegaspari.livroteca.model.LivrosModel;
import com.maurodegaspari.livroteca.repositories.LivrosRepository;

@Service
public class LivrosServices {

	private LivrosRepository repo;
	private LivrosConversao conversao;
	private CategoriaService categoria;

	@Autowired
	public LivrosServices(LivrosRepository repo, LivrosConversao conversao, CategoriaService categoria) {
		this.repo = repo;
		this.conversao = conversao;
		this.categoria = categoria;
	}

	@Transactional(readOnly = true)
	public Optional<LivrosDto> findById(int id) {
		LivrosDto dto = new LivrosDto();
		Optional<LivrosModel> model = repo.findById(id);

		try {
			if (!model.isPresent()) {
				throw new NotFoundException("Livro não encontrado.");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new NotFoundException(e.getMessage());
		}

		BeanUtils.copyProperties(model.get(), dto);

		return Optional.of(dto);
	}
	
	
	public List<LivrosDto> todosLivrosCategoria(int id) {
		categoria.findById(id);
		List<LivrosDto> livrosPorCategorias = repo.acharLivrosCategorias(id);
		return livrosPorCategorias;
	}

	public void deleteLivro(int id) {
		Optional<LivrosModel> model = repo.findById(id);		
		
		try {
			
			if (model.isEmpty()) {
				throw new NotFoundException("Livro não encontrado para deletar");
			}else {
				repo.deleteById(id);
				
			}
				
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new NotFoundException(e.getMessage());
		}
		
	}
}
