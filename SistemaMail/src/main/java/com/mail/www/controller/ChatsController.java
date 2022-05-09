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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mail.www.entity.Chats;
import com.mail.www.entity.Usuarios;
import com.mail.www.model.JwtToken;
import com.mail.www.services.IChatsService;
import com.mail.www.services.IUsuarioService;
 

@RestController
@RequestMapping("/api2")
public class ChatsController {

	@Autowired
	private IChatsService service;
	
	@Autowired
	private IUsuarioService serviceU;

	@RequestMapping(value = "/enviar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> enviar(@Valid @RequestBody Chats chats, BindingResult result) {
		Map<String, Object> mensajes = new HashMap<>();
		Chats verificar = new Chats();
		Usuarios usuario = new Usuarios();
		usuario.setMail(chats.getMailE());
		JwtToken token = new JwtToken();
		
		// token recibido por el cliente 
				token.setToken(null);

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			mensajes.put("error", errors);
			return new ResponseEntity<Map<String, Object>>(mensajes, HttpStatus.BAD_REQUEST);
		}

	

		try {
			usuario = serviceU.verificacionMail(usuario);
			verificar = service.comprobarR(chats);
			if (usuario == null && verificar == null) {
				mensajes.put("proceso", "usuario esta vacio");
				mensajes.put("proceso", "No existe el receptor ");
				return new ResponseEntity<Map<String, Object>>(mensajes, HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				chats.setCategoria("Todos");
				chats.setEstado("Enviado");
				chats.setUsuario(usuario);
				service.crear(chats); 
				mensajes.put("proceso", "usuario se lleno"); 

			}

		} catch (DataAccessException ex) {
			mensajes.put("respuesta", "No se envio el mensaje");
			mensajes.put("error", ex.getMessage().concat(":").concat(ex.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(mensajes, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		verificar.prePersist();
		mensajes.put("chats", chats);
		return new ResponseEntity<Map<String, Object>>(mensajes, HttpStatus.CREATED);

	}

	@GetMapping("/enviados")
	public ResponseEntity<?> enviados() {
		List<Chats> mail = service.listar();
		Map<String, Object> mensaje = new HashMap<>(); 
		JwtToken token = new JwtToken();
		
		// token recibido por el cliente 
		token.setToken(null);
		
		
		
		if (mail.size() > 0) {
			return new ResponseEntity<List<Chats>>(mail, HttpStatus.OK);
		} else {
			mensaje.put("respuesta", "No has enviado ningun mail "); 
			return new ResponseEntity<Map<String, Object>>(mensaje, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@GetMapping("/recibidos")
	public ResponseEntity<?> recibidos (){
		
		List<Chats> recibidos = service.listar();
		Map<String, Object> mensaje = new HashMap<String, Object>();
		JwtToken token = new JwtToken();
		// token recibido por el cliente 
				token.setToken(null);
		
		
		if (recibidos.size()>0) {
			return new ResponseEntity<List<Chats>>(recibidos,HttpStatus.OK);
		}else {
			mensaje.put("respuesta", "No has recibido ningun mail");
			return new ResponseEntity<Map<String, Object>>(mensaje,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	@GetMapping("/destacados")
	public ResponseEntity<?> destacados(){
		List<Chats> destacado = service.listar();
		Map<String, Object> mensaje = new HashMap<String, Object>();
		JwtToken token = new JwtToken();
		// token recibido
		token.setToken(null);
		
		if (destacado.size()>0) {
			return new ResponseEntity<List<Chats>>(destacado, HttpStatus.OK);
		}else {
			mensaje.put("respuesta", "No has destacado ningun mensaje ");
			return new ResponseEntity<Map<String, Object>>(mensaje, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}  
	
	@GetMapping("/borrados")
	public ResponseEntity<?> borrado(){
		List<Chats> borrados = service.listar();
		Map<String, Object> mensaje = new HashMap<String, Object>();
		JwtToken token = new JwtToken();
		// token recibido
		token.setToken(null);
		
		if (borrados.size()>0) {
			return new ResponseEntity<List<Chats>>(borrados, HttpStatus.OK);
		}else {
			mensaje.put("respuesta", "No has borrado ningun mensaje ");
			return new ResponseEntity<Map<String, Object>>(mensaje, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}  
	
}












