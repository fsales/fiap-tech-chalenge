package br.com.fsales.eletrotech.dominio.pessoa.controller.validation;


import br.com.fsales.eletrotech.dominio.pessoa.enumeration.SexoEnum;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 *
 */
public class SexoValidatorImpl implements ConstraintValidator<Sexo, String> {

    @Override
    public void initialize(Sexo constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        return SexoEnum.getEnum(value) != null;
    }
}
