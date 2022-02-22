package com.jared.ejemplos.springboot.registro.app.editora;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jared.ejemplos.springboot.registro.app.service.PaisService;

@Component
public class PaisPropertyEditor extends PropertyEditorSupport {

	@Autowired
	private PaisService service;

	@Override
	public void setAsText(String idString) throws IllegalArgumentException {
		 

			try {
				Integer id = Integer.parseInt(idString);
				this.setValue(service.obtenerID(id));
			}

			catch (IllegalArgumentException e) {
				setValue(null);
			}
			 
		}
		
	}


