package com.mail.www.services;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mail.www.entity.Usuarios;
import com.mail.www.repositories.IUsuarioRepository;

@Service
public class UsuarioImplService implements IUsuarioService{

	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@Override
	@Transactional(readOnly=true)
	public List<Usuarios> listar() {
		 
		return usuarioRepository.findAll();
	}
	
	@Override
	@Transactional
	public Usuarios insertar(Usuarios usuarios) {
		return  usuarioRepository.save(usuarios);
	}
	@Override
	@Transactional
	public Usuarios comprobarLogin(Usuarios usuarios) {
		
		return usuarioRepository.findByMailAndContrasena(usuarios.getMail(), usuarios.getContrasena());
	}

	@Override
	public Usuarios verificacionMail(Usuarios usuarios) {
		 
		return usuarioRepository.findByMail(usuarios.getMail());
	}
	

	
	
}
