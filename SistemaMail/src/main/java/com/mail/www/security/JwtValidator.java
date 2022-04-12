package com.mail.www.security;

import org.springframework.stereotype.Component;

import com.mail.www.constants.Constants;
import com.mail.www.entity.Usuarios; 

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
//validacion
@Component
public class JwtValidator {

	public Usuarios validate(String token) {
		Usuarios usuario = null;
		
		try {
			Claims body = Jwts.parser()
					.setSigningKey(Constants.YOUR_SECRET)
					.parseClaimsJws(token)
					.getBody();
			
			usuario = new Usuarios();
			usuario.setNombre(body.getSubject());
			usuario.setIdU(Long.parseLong((String) body.get(Constants.USER_ID)));
			usuario.setRole((String) body.get(Constants.ROLE));
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return usuario;
	}
	
}
