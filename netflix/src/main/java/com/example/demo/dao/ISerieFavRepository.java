package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.SerieFavorita;

public interface ISerieFavRepository extends CrudRepository<SerieFavorita, String> {

}
