package com.jared.ejemplos.springboot.registro.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jared.ejemplos.springboot.registro.app.models.domain.Role;
@Service
public class RoleServiceImpl implements RoleService {

	private List<Role> roles;
	
	@Override
	public List<Role> listar() {
		// TODO Auto-generated method stub
		
		return roles;
	}

	@Override
	public Role obtenerPorId(Integer id) {
		
	Role resultado = null;
	for (Role role: roles )
	{
		if (id==role.getId())
		{
			resultado=role;
			break;
		}
	}
		return resultado;
	}

	public RoleServiceImpl() { 
		this.roles= new ArrayList<>();
		this.roles.add(new Role (1,"Cliente VIP","VIP"));
		this.roles.add(new Role (2,"Cliente Nuevo","NEW"));
		this.roles.add(new Role (3,"Cliente Frecuente","Frecuente"));
		// TODO Auto-generated constructor stub
	}
	
	

}
