package com.jared.ejemplos.springboot.registro.app.service;
 
import java.util.List;
 
import com.jared.ejemplos.springboot.registro.app.models.domain.Role;
 
public interface RoleService {
	
	public List<Role> listar(); 
	public Role obtenerPorId(Integer id);

}
