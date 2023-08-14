package br.com.fsales.eletrotech.pessoa.presentation.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Documented

@Constraint(validatedBy = ParentescoValidatorImpl.class)
public @interface Parentesco {
    String message() default "A sigla do parentescoEnum não existente.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
