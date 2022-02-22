package com.bolsadeisdeas.springboot.web.app.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping; 

@Controller
// nose mapea porque se redirije 
public class HomeController {
	
	// redirigiendo a la ruta app/' o app/index 
	
	@GetMapping("/")
	public String home()
	{
		// cambia la ruta
		//return "redirect:https://www.google.com";
		//return "redirect:/app/index";
		//no cambia la ruta del proyecto
		return "forward:/app/index";
	}

}
