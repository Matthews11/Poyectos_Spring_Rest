package com.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.entity.Lector;
import com.biblioteca.service.contrato.LectorService;

@RestController
@RequestMapping("/lector")
public class LectorController extends GenericController<Lector,LectorService> {

	@Autowired
	public LectorController(LectorService servicio) {
		super(servicio);
		// TODO Auto-generated constructor stub
	}

}
