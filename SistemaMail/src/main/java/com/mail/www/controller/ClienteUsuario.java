package com.mail.www.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.mail.www.entity.Usuarios;

@Controller
@RequestMapping("mail")
public class ClienteUsuario {

	@Autowired
	private RestTemplate restTemplate;
	
	
	@PostMapping("/ingresar")
	public String crearClientes(@RequestBody Usuarios usuario) {

		HttpHeaders headers = new HttpHeaders(); 
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));   
		HttpEntity<Usuarios> entity = new HttpEntity<Usuarios>(usuario, headers);  
		ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:7777/api/registrarse",
				HttpMethod.POST, entity, String.class);
		
		
		return responseEntity.getBody();
	}
	
	
	@GetMapping("/formulario")
	public String crearFormulario(Model model) {
		Usuarios usuarios = new Usuarios();
		model.addAttribute("usuario", usuarios);
		model.addAttribute("titulo", "Registrarse");
		model.addAttribute("boton", "Ingresar");
		return "Usuario/ingresar";
		
	}
	
	
	
	
}
