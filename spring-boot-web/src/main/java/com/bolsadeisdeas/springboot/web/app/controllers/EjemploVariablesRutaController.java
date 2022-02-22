package com.bolsadeisdeas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("titulo", "Enviar parametros del request HTTP GET -URL (@PathVariable)");
		return "variables/index";
	}

	@GetMapping("/string/{texto}")
	// metodo para capturar variables y limpia recibe una variable
	public String variables(@PathVariable String texto, Model model) {
		model.addAttribute("titulo", "Recibir parametros del request HTTP GET -URL (@PathVariable)");
		model.addAttribute("resultado", "El texto envia de la ruta es: " + texto);
		return "variables/ver";
	}

	@GetMapping("/string/{texto}/{numero}")
	// metodo para capturar variables y limpia recibe 2 variable
	public String variables(@PathVariable String texto, @PathVariable Integer numero, Model model) {
		model.addAttribute("titulo", "Recibir parametros del request HTTP GET -URL (@PathVariable)");
		model.addAttribute("resultado", "El texto envia de la ruta es: " + texto + " El numero es:" + numero);
		return "variables/ver";
	}

}
