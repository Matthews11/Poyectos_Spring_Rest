package com.mail.www.services;

 

import java.util.List;

import com.mail.www.entity.Usuarios;

public interface IUsuarioService {

	public List<Usuarios> listar();
	
	public Usuarios insertar(Usuarios usuarios);   
	
	public Usuarios comprobarLogin(Usuarios usuarios );
	
	public Usuarios verificacionMail(Usuarios usuarios);
	
	
}
