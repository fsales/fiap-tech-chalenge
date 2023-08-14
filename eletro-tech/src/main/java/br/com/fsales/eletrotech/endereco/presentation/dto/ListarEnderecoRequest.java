package br.com.fsales.eletrotech.endereco.presentation.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.util.UUID;

public record ListarEnderecoRequest(

        @Schema(name = "idPessoa",
                example = "fed3f974-3b1e-449d-bcd6-3a8450b09fb9"
        )
        UUID idPessoa,
        @Schema(name = "rua",
                example = "Praça da Sé"
        )
        String rua,
        @Schema(name = "bairro",
                example = "Sé"
        )
        String bairro,
        @Schema(name = "cidade",
                example = "São Paulo"
        )
        String cidade,
        @Schema(name = "siglaEstado",
                example = "SP"
        )
        String siglaEstado
) implements Serializable {

}
