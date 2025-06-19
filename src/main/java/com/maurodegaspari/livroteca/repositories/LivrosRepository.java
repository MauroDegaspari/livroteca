package com.maurodegaspari.livroteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maurodegaspari.livroteca.model.LivrosModel;

public interface LivrosRepository extends JpaRepository<LivrosModel, Integer> {

}
