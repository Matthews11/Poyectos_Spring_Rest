package com.jared.ejemplos.springboot.registro.app.service;

import java.util.List;

import com.jared.ejemplos.springboot.registro.app.modelo.Pais;
  

public interface PaisService {
 

	public List<Pais> listar ();
	
	public Pais obtenerID(Integer id);
}
