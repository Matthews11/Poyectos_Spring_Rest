package com.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.entity.Editorial;
import com.biblioteca.service.contrato.EditorialService;

@RestController
@RequestMapping("/editorial")
public class EditorialController extends GenericController<Editorial, EditorialService>{

	@Autowired
	public EditorialController(EditorialService servicio) {
		super(servicio);
		// TODO Auto-generated constructor stub
	}
}
