package com.biblioteca.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.entity.Alquiler;
@Repository
public interface AlquilerRepository extends CrudRepository<Alquiler, Long> {

}
