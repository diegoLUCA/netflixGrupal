package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.PeliculaFavorita;

public interface IPelFavoritaRepository extends CrudRepository<PeliculaFavorita, String> {

}
