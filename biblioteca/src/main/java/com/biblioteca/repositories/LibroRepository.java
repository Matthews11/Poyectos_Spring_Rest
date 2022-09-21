package com.biblioteca.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.entity.Libro;
@Repository
public interface LibroRepository extends CrudRepository<Libro, Long>{

}
