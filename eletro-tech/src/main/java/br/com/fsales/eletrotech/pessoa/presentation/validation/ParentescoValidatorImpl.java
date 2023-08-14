package br.com.fsales.eletrotech.pessoa.presentation.validation;

import br.com.fsales.eletrotech.pessoa.domain.enumeration.ParentescoEnum;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ParentescoValidatorImpl implements ConstraintValidator<Parentesco, String> {
    @Override
    public void initialize(Parentesco constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        return value == null || ParentescoEnum.getEnum(value) != null;
    }
}
