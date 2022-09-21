package com.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.entity.Alquiler;
import com.biblioteca.service.contrato.AlquilerService;

@RestController
@RequestMapping("/alquiler")
public class AlquilerController extends GenericController<Alquiler,AlquilerService>{

	@Autowired
	public AlquilerController(AlquilerService servicio) {
		super(servicio);
		// TODO Auto-generated constructor stub
	}

}
