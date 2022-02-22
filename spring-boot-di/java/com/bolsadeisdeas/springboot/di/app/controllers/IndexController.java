package com.bolsadeisdeas.springboot.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeisdeas.springboot.di.app.models.service.IServicio;

@Controller
@RequestMapping()
public class IndexController {

	//ejemplificaciones de inyeccion a constructor y metodo set

	/*@Autowired
	public void setServicio(IServicio servicio) {
		this.servicio = servicio;
	}


	@Autowired
	public IndexController(IServicio servicio) {
		super();
		this.servicio = servicio;
	}
	
	
	*/
	
	
	
	@Autowired // asi se inyecta las clases
	@Qualifier("miServicioComplejo")
	private IServicio servicio ;
	
	@GetMapping({"/","","/index"})
	public String index(Model model)
	{
		model.addAttribute("objeto", servicio.operacion());
		
		return "index";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

 

}
