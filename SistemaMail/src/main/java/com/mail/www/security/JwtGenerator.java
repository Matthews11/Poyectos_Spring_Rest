package com.mail.www.security;

import org.springframework.stereotype.Component;

import com.mail.www.constants.Constants;
import com.mail.www.entity.Usuarios;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

//generador
@Component
public class JwtGenerator {
	public String generate(Usuarios usuario   ) {
		Claims claims = Jwts.claims()
				.setSubject(usuario.getNombre());
		claims.put(Constants.USER_ID, String.valueOf(usuario.getIdU()));
		claims.put(Constants.ROLE, usuario.getRole());
		
		return Jwts.builder()
				.setClaims(claims)
				.signWith(SignatureAlgorithm.HS256, Constants.YOUR_SECRET)
				.compact();
		
	}
}
