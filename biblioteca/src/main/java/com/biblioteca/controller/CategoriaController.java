package com.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.entity.Categoria;
import com.biblioteca.service.contrato.CategoriaService; 

@RestController
@RequestMapping("/categoria")
public class CategoriaController extends GenericController<Categoria, CategoriaService>{

	@Autowired
	public CategoriaController(CategoriaService repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}

}
