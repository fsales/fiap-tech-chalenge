package br.com.fsales.eletrotech.infrastructure.handler.exception.dto;

import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Value
public class ValidationErrorResponse {

    private final List<Violation> violations = new ArrayList<>();

    public void violation(Violation violation) {
        violations.add(violation);
    }

}
