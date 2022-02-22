package com.jared.ejemplos.springboot.registro.app.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdRgexValidador implements ConstraintValidator<IdRegex, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		if(!value.matches("[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")==false)
		{
			return true;

		}
		return false;
	}

}
