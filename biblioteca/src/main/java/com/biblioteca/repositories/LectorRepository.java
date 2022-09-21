package com.biblioteca.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.entity.Lector;
@Repository
public interface LectorRepository extends CrudRepository<Lector, Long>{

}
