package com.jared.ejemplos.springboot.form.app.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.jared.ejemplos.springboot.form.app.models.domain.Usuario;
import com.jared.ejemplos.springboot.form.app.validacion.UsuarioValidacion; 

@Controller
@SessionAttributes("usuario")
public class FormController {

	@Autowired
	private UsuarioValidacion validador;
	
	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario();
		// envio de datos predeterminado
		
		usuario.setUs("jaredo");
		usuario.setApellido("molina");
		usuario.setId("12.458.168-K");
		model.addAttribute("titulo", "formulario usuario");
		model.addAttribute("usuario", usuario);
		return "form";
	}

	@PostMapping("/form") // recibe un objeto y automaticamente se puebla
	public String procesar(@Valid Usuario usuario, BindingResult validacion, Model model, SessionStatus status) {
		validador.validate(usuario, validacion);
		

		if (validacion.hasErrors()) {
		/*	 se crea una lista donde se va llenado con los errores que optubo y lo manda a
			 la vista
			Map<String, String> errores = new HashMap<>();
			validacion.getFieldErrors().forEach(err -> {
				errores.put(err.getField(),
						"El campo ".concat(err.getField()).concat("  ").concat(err.getDefaultMessage()));

			});
*/
			 
			return "form";
		}

		else {

			model.addAttribute("titulo", "resultado del form");
			model.addAttribute("usuario", usuario);

			status.setComplete();
			return "resultado";
		}
	}
}
