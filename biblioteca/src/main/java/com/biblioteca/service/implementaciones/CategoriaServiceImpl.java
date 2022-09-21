package com.biblioteca.service.implementaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.entity.Categoria;
import com.biblioteca.repositories.CategoriaRepository;
import com.biblioteca.service.contrato.CategoriaService;

@Service
public class CategoriaServiceImpl extends GenericoServiceImpl<Categoria, CategoriaRepository> implements CategoriaService{

	@Autowired
	public CategoriaServiceImpl(CategoriaRepository repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}
	

}
