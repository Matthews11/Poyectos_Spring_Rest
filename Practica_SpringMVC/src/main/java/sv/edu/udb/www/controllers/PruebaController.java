package sv.edu.udb.www.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Ejemplo")
public class PruebaController {
	
	@GetMapping({"saludo","/"})
	public String saludo(Model model) {
		model.addAttribute("nombre", "Jared");
		return "saludo";
	}

}
