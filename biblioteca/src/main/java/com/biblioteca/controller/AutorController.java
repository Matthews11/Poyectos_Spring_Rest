package com.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.entity.Autor;
import com.biblioteca.service.contrato.AutorService;

@RestController
@RequestMapping("/autor")
public class AutorController extends GenericController<Autor, AutorService> {

	@Autowired
	public AutorController(AutorService servicio) {
		super(servicio);
		// TODO Auto-generated constructor stub
	}

}
