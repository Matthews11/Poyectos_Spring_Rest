package com.bolsadeisdeas.springboot.di.app.models.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
// se registra la clase con spring

//@Component("miServicioSimple")
//@Primary
public class MiServicio implements IServicio{
	
	
	
	
	@Override
	public String operacion()
	{
		return "Ejecutando un proceso Simple";
	}
	

}
