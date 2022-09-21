package com.biblioteca.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.entity.Categoria;
@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long>{

}
