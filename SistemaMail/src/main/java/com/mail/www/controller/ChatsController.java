package com.mail.www.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult; 
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mail.www.entity.Chats; 
import com.mail.www.entity.Usuarios;
import com.mail.www.model.Mail;
import com.mail.www.services.IChatsService;
import com.mail.www.services.IMailService;
import com.mail.www.services.IUsuarioService;

@RestController
@RequestMapping("/api2")
public class ChatsController {
	
	@Autowired
	private IChatsService service;
	
	@Autowired
	private IUsuarioService serviceU;
	
	@Autowired
	private IMailService serviceMail;
	
	 @RequestMapping(value="/enviar", method = RequestMethod.POST,
			    consumes =  MediaType.APPLICATION_JSON_VALUE,
				produces =  MediaType.APPLICATION_JSON_VALUE )
	 public ResponseEntity<?> enviar(@Valid @RequestBody Chats chats, BindingResult result){
		Map<String, Object> mensajes = new HashMap<>(); 
		Chats pref= new Chats();
		Usuarios usuario= new Usuarios(); 
		usuario.setMail(chats.getMailE());
		//Mail mail = new Mail();
		
		if (result.hasErrors()){
			List<String> errors = result.getFieldErrors().stream()
					.map(err-> "El campo '"+err.getField()+"' "+err.getDefaultMessage())
					.collect(Collectors.toList());
			
			mensajes.put("error",errors);
			return new ResponseEntity<Map<String,Object>>(mensajes,HttpStatus.BAD_REQUEST);
		} 
		
		pref.prePersist();
		
		try {
			usuario=serviceU.verificacionMail(usuario); 
			 
			if (usuario==null) {
				mensajes.put("proceso", "usuario esta vacio");
				return new ResponseEntity<Map<String,Object>>(mensajes,HttpStatus.INTERNAL_SERVER_ERROR);
			}else {
				chats.setCategoria("ninguno");
				chats.setEstado("enviado");
				chats.setUsuario(usuario);
				service.crear(chats);

				//mail.setSenderEmail(usuario.getMail());
			//	mail.setSenderPassword(usuario.getContrasena());
				mensajes.put("proceso","usuario se lleno");
				
			}
			
			
		} catch (DataAccessException ex) {
			mensajes.put("respuesta", "No se envio el mensaje");
			mensajes.put("error", ex.getMessage().concat(":").concat(ex.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>> (mensajes, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		try {
			serviceMail.enviar(chats.getMailR(), chats.getTitulo(), chats.getDescripcion());
		} catch (MessagingException e) {
			mensajes.put("respuesta", "hubo un error en envio del mail");
			mensajes.put("error", e.getCause().getMessage());
			e.printStackTrace();
		
		}
		 
		  
		 mensajes.put("chats", chats);
		 return new ResponseEntity<Map<String,Object>>(mensajes,HttpStatus.CREATED);
		  
	 }
	 
 
	
}
