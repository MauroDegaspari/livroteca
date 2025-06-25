package com.maurodegaspari.livroteca.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.maurodegaspari.livroteca.dto.LivrosDto;
import com.maurodegaspari.livroteca.model.LivrosModel;

public interface LivrosRepository extends JpaRepository<LivrosModel, Integer> {

	@Query(value = "SELECT id, "
			     + "       titulo,"
			     + "       nome_autor "
			     + "  FROM livros"
			     + " WHERE categoria_id = :id_categoria ", nativeQuery = true)
	List<LivrosDto> acharLivrosCategorias(@Param(value = "id_categoria")int id_categoria);

}
