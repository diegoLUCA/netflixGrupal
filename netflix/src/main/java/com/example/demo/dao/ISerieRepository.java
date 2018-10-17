package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Serie;

public interface ISerieRepository extends CrudRepository<Serie, Integer> {

}
