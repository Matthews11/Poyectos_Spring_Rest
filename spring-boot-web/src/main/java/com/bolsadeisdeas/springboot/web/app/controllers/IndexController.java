package com.bolsadeisdeas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeisdeas.springboot.web.app.models.Usuario;

//se pone controlador para que se configure como tal
@Controller
// ruta a la cual se accedera
@RequestMapping ("/app")
public class IndexController {

//inyeccion a variables con property
	// se especifica el controlador. el metodo. y la varible 
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	
	
	// se mapea para que se le asigne una ruta
	
	@GetMapping({ "/index", "/", "/home" })
	public String index(Model model) {
		
		//pasando varaible titulo con el valor de hola a la vista index o vista 
		model.addAttribute("titulo", textoIndex);

		return "index";

	}
	
	// mapeo aca ingresar y sale la infromacion en la url
	@RequestMapping ("/perfil")
	public String perfil(Model model)
	{
		Usuario usuario = new Usuario();
		
		usuario.setNombre("Jared");
		usuario.setApellido("Pineda");
		usuario.setEmail("Jaredpineda033@gmail.com");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));
		// en el html nombrado perfil se presenta 
		return "perfil";
	}
	
// mapeo
	@RequestMapping ("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", textoListar);
		
		return "listar";
	}
	
	/// con model artibute todos los mapeo van a tener acceso solo faltara llamarlos con thymeleaf
	@ModelAttribute("usuarios")
	public List<Usuario> poblar()
	{
		List<Usuario> usuarios = Arrays.asList(new Usuario ("Jared","Pineda","Jaredpineda033@gmail.com"),
				new Usuario ("Mathew","Molina","mateo12molina@gmail.com"),
				new Usuario("Mateo","Rodriguez","mateo18molina@gmail.com"));
		return usuarios;
	}
	
	
	
	
	
	
	
	

}
