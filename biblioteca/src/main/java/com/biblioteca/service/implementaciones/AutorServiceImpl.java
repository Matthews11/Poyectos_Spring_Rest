package com.biblioteca.service.implementaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.entity.Autor;
import com.biblioteca.repositories.AutorRepository;
import com.biblioteca.service.contrato.AutorService;

@Service
public class AutorServiceImpl extends GenericoServiceImpl<Autor,AutorRepository> implements AutorService{

	@Autowired
	public AutorServiceImpl(AutorRepository repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}

}
