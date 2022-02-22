package com.jared.ejemplos.springboot.form.app.validacion;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.jared.ejemplos.springboot.form.app.models.domain.Usuario;
@Component
public class UsuarioValidacion implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
	 
		
		return Usuario.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Usuario usuario = (Usuario)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "us" , "El campo no puede estar vacio");
		
	 	if(!usuario.getId().matches("[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")==false)
		{
		 errors.rejectValue("id", "Formato de la expresion regular incorrecto");
		}

	}


}
