package br.com.fsales.eletrotech.infrastructure.handler.exception.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@Builder
@RequiredArgsConstructor
public class Violation {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String fieldName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String message;
}
