package br.com.fsales.eletrotech.dominio.pessoa.validate;

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

@Constraint(validatedBy = SexoValidatorImpl.class)
public @interface Sexo {
    String message() default "A sigla do sexo não existente.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
