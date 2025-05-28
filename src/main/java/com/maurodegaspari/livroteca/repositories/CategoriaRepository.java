package com.maurodegaspari.livroteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maurodegaspari.livroteca.domain.CategoriaModel;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Integer>{

}
