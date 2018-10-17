package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Pelicula;

public interface IPeliculaRepository extends CrudRepository<Pelicula, Integer> {

}
