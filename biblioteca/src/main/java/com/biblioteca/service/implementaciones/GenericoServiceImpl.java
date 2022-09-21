package com.biblioteca.service.implementaciones;

import java.util.List;
import java.util.Optional;


import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.biblioteca.service.contrato.GenericoService;

public class GenericoServiceImpl <E,R extends CrudRepository<E, Long>> implements GenericoService<E>{
	
	protected final R repo;
	
	public GenericoServiceImpl(R repo) {
		this.repo = repo;
		
	}
	@Override
	@Transactional(readOnly = true)
	public Optional<E> obtener(Long id) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(repo.findById(id)).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<E> listar() {
		// TODO Auto-generated method stub
		return (List<E>) repo.findAll();
	}

	@Override
	@Transactional
	public E crear(E e) {
		// TODO Auto-generated method stub
		return repo.save(e);
	}

	@Override
	@Transactional
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
