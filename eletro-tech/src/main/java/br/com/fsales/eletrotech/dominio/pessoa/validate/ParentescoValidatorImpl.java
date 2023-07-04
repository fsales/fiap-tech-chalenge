package br.com.fsales.eletrotech.dominio.pessoa.validate;

import br.com.fsales.eletrotech.dominio.pessoa.enumeration.ParentescoEnum;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ParentescoValidatorImpl implements ConstraintValidator<Parentesco, String> {
    @Override
    public void initialize(Parentesco constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return ParentescoEnum.getEnum(value) != null;
    }
}
