package com.biblioteca.service.implementaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
  
import com.biblioteca.entity.Libro; 
import com.biblioteca.repositories.LibroRepository; 
import com.biblioteca.service.contrato.LibroService;

@Service
public class LibroServiceImpl extends GenericoServiceImpl<Libro, LibroRepository> implements LibroService{

	@Autowired
	public LibroServiceImpl(LibroRepository repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}
	

}
