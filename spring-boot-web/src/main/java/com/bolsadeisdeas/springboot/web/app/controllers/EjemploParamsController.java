package com.bolsadeisdeas.springboot.web.app.controllers;



import javax.servlet.http.HttpServlet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// envios de parametros por rutas 
@Controller
@RequestMapping("/params")
public class EjemploParamsController {
	
	@GetMapping("/")
	public String index()
	{
		
		return "params/index";
	}
	
	@GetMapping("/string")
	public String param (@RequestParam(name="texto",required = false,defaultValue = "No se recibio ningun parametro") String texto,Model model)
	{
		
		model.addAttribute("resultado", "EL parametro enviado es:"+texto);
		return "params/ver";
		
	}
	
	// forma mejor
	@GetMapping("/mix-params")
	public String param (@RequestParam String saludo,@RequestParam Integer numero,Model model)
	{
		
		model.addAttribute("resultado", "EL saludo  enviado es:"+saludo+" El numero es"+numero);
		return "params/ver";
		
	}
	
	// forma tradicional de capturar parametro con servlet
	@GetMapping("/mix-params-request")
	public String param (HttpServlet request,Model model)
	{
		String saludo=request.getInitParameter("saludo");
		Integer numero = Integer.parseInt( request.getInitParameter("numero"));
		model.addAttribute("resultado", "EL saludo  enviado es:"+saludo+" El numero es"+numero);
		return "params/ver";
		
	}

}
