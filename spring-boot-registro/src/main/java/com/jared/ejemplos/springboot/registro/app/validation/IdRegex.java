package com.jared.ejemplos.springboot.registro.app.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
@Constraint(validatedBy =IdRgexValidador.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface IdRegex {
	String message() default "Id invalido";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}

 