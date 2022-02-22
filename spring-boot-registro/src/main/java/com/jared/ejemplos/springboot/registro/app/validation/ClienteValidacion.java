package com.jared.ejemplos.springboot.registro.app.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.jared.ejemplos.springboot.registro.app.modelo.Cliente;
@Component
public class ClienteValidacion implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Cliente.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		Cliente client = (Cliente)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre" , "NotEmpty.cliente.nombre");
		
	 /*if(!client.getId().matches("[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")==false)
		{
		 errors.rejectValue("id", "patter.cliente.id");
		}*/

	}

}
