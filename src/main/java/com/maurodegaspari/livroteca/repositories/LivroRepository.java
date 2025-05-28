package com.maurodegaspari.livroteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maurodegaspari.livroteca.domain.LivrosModel;

public interface LivroRepository extends JpaRepository<LivrosModel, Integer> {

}
