package com.mail.www.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mail.www.entity.Usuarios;
import com.mail.www.model.JwtToken;
import com.mail.www.security.JwtGenerator;
import com.mail.www.services.IUsuarioService;


@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	private IUsuarioService service;

	private JwtGenerator jwtGenerator;
	 
	public UsuarioController(JwtGenerator jwtGenerator) { 
		this.jwtGenerator = jwtGenerator;
	}

	@RequestMapping(value = "/registrarse", method = RequestMethod.POST, 
			consumes =MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> registrarse(@Valid @RequestBody Usuarios usuarios, BindingResult result ) {
		Map<String, Object> mensajes = new HashMap<>();
		Usuarios pref = new Usuarios();
		Usuarios verificacion = new Usuarios();
		
		if (result.hasErrors()){
			List<String> errors = result.getFieldErrors().stream()
					.map(err-> "El campo '"+err.getField()+"' "+err.getDefaultMessage())
					.collect(Collectors.toList());
			
			mensajes.put("error",errors);
			return new ResponseEntity<Map<String,Object>>(mensajes,HttpStatus.BAD_REQUEST);
		}
		
		
		try {
			verificacion = service.verificacionMail(usuarios);

			if (verificacion == null) {
				usuarios.setRole("cliente");
				service.insertar(usuarios);
			} else {
				mensajes.put("error", "Ya existe un mail registrado");
				return new ResponseEntity<Map<String, Object>>(mensajes, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (DataAccessException ex) {
			mensajes.put("respuesta", "No se pudo registrar el usuario");
			mensajes.put("error", ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));

			return new ResponseEntity<Map<String, Object>>(mensajes, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		pref.prePersist();
		mensajes.put("respuesta", "Usuario registrado con exito");

		return new ResponseEntity<Map<String, Object>>(mensajes, HttpStatus.CREATED);

	}

	@PostMapping(value = "/iniciarSesion", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> login(@RequestBody Usuarios usuarios) {
		Map<String, Object> mensajes = new HashMap<>();
		Usuarios usuario = null;
		Usuarios verificacion = new Usuarios(); 
		JwtToken token = new JwtToken();
		try {
			usuario = service.comprobarLogin(usuarios);

			if (usuario != null) {
				mensajes.put("respuesta", "usuario verificado");
				mensajes.put("Usuario", usuario);
				verificacion = service.verificacionMail(usuarios);
				token.setToken(jwtGenerator.generate(verificacion)); 
				
				mensajes.put("Token", token.getToken());
			} else {
				mensajes.put("respuesta", "Datos Incorrectos ");
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
		} catch (DataAccessException ex) {
			mensajes.put("respuesta", "Ocurrio un problema con la consulta");
			mensajes.put("error", ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));

			return new ResponseEntity<Map<String, Object>>(mensajes, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Map<String, Object>>(mensajes, HttpStatus.ACCEPTED);
	}

 

}
