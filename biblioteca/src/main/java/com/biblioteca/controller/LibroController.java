package com.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.entity.Libro;
import com.biblioteca.service.contrato.LibroService;

@RestController
@RequestMapping("/libro")
public class LibroController extends GenericController<Libro,LibroService> {

	@Autowired
	public LibroController(LibroService servicio) {
		super(servicio);
		// TODO Auto-generated constructor stub
	}

}
