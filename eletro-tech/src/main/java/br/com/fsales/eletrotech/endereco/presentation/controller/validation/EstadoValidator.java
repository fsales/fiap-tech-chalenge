package br.com.fsales.eletrotech.endereco.presentation.controller.validation;

import br.com.fsales.eletrotech.endereco.domain.enumeration.EstadoEnum;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EstadoValidator implements ConstraintValidator<Estado, String> {

    /**
     * @param constraintAnnotation
     */
    @Override
    public void initialize(Estado constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    /**
     * @param value
     * @param constraintValidatorContext
     * @return
     */
    @Override
    public boolean isValid(
            String value,
            ConstraintValidatorContext constraintValidatorContext
    ) {
        return EstadoEnum.getEnum(value) != null;
    }
}
