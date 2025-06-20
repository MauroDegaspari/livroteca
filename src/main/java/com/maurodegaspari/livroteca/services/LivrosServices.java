package com.maurodegaspari.livroteca.services;

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

	@Autowired
	public LivrosServices(LivrosRepository repo, LivrosConversao conversao) {
		this.repo = repo;
		this.conversao = conversao;
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
}
