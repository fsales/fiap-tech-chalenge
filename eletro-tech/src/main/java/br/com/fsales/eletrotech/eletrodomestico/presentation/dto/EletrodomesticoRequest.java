package br.com.fsales.eletrotech.eletrodomestico.presentation.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record EletrodomesticoRequest(
        @Schema(name = "idPessoa",
                example = "c9dbd0c4-bb7b-4903-8f84-841d5a8644df"
        )
        @NotNull
        UUID idPessoa,
        @Schema(name = "idEndereco",
                example = "3d02f4c7-91d5-4f46-9ecd-5da4254cf5b0"
        )
        @NotNull
        UUID idEndereco,
        @Schema(name = "nome",
                example = "Micro-ondas 20L"
        )
        @NotEmpty
        String nome,

        @Schema(name = "modelo",
                example = "MT30S"
        )
        @NotEmpty
        String modelo,

        @Schema(name = "potencia",
                example = "1150"
        )
        @NotNull
        Integer potencia,

        @Schema(name = "fabricante",
                example = "Electrolux"
        )
        @NotEmpty
        String fabricante,

        @Schema(name = "voltagem",
                example = "220"
        )
        @NotNull
        Integer voltagem,

        @Schema(name = "tempoUsoDiario",
                example = "1"
        )
        @NotNull
        Integer tempoUsoDiario
) {
}
