package com.jared.ejemplos.springboot.registro.app.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

 

public class RequeridoValidador implements ConstraintValidator<Requerido, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		
		if(value==null|| !org.springframework.util.StringUtils.hasText(value))
		{
			return false;
		}
		return true;
		
	}

}
