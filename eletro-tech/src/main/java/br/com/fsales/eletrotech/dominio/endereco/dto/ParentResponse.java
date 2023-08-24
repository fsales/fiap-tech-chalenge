package br.com.fsales.eletrotech.dominio.endereco.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

public record ParentResponse(
        @Schema(name = "id",
                example = "f6c323ed-968f-43fc-aa3a-b25a764b4d5d"
        )
        UUID idPessoa,
        @Schema(name = "nome",
                example = "Marcos Andre"
        )
        String nome,
        @Schema(name = "sobrenome",
                example = "Andrade"
        )
        String sobrenome,
        @Schema(name = "parent",
                implementation = ParentResponse.class,
                anyOf = {ParentResponse.class}
        )
        @JsonInclude(JsonInclude.Include.NON_NULL)
        ParentResponse parent
) {
}
