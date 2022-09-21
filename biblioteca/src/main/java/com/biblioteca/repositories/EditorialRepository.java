package com.biblioteca.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.entity.Editorial;
@Repository
public interface EditorialRepository extends CrudRepository<Editorial, Long>{

}
