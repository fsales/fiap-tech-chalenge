package br.com.fsales.eletrotech.infrastructure.exception.dto;

import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Value
public class ValidationErrorResponse {

    private final List<Violation> violations = new ArrayList<>();

    public void violation(Violation violation) {

        this.violations.add(violation);
    }

    public void violation(List<Violation> violations) {
        if (violations != null)
            this.violations.addAll(violations);
    }

}
