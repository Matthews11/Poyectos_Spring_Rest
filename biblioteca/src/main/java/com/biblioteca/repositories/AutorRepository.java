package com.biblioteca.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.entity.Autor;
@Repository
public interface AutorRepository extends CrudRepository<Autor, Long>{

}
