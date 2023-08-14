package br.com.fsales.eletrotech.eletrodomestico.presentation.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record DadosAtualizarEletrodomesticoRequest(
        @Schema(name = "id",
                example = "7d0607d3-f2a3-4d53-b0e4-a8fc963be117"
        )

        @NotNull
        UUID id,
        @Schema(name = "idPessoa",
                example = "608f3f7d-67da-4ea6-ba56-55d9a3721dd2"
        )
        @NotNull
        UUID idPessoa,
        @Schema(name = "idEndereco",
                example = "d86a5f0d-3145-496c-bc9c-1eff2ad89fca"
        )
        @NotNull
        UUID idEndereco,
        @Schema(name = "nome",
                example = "Microondas"
        )
        @NotEmpty
        String nome,

        @Schema(name = "modelo",
                example = "MRAS222"
        )
        @NotEmpty
        String modelo,

        @Schema(name = "potencia",
                example = "800"
        )
        @NotNull
        Integer potencia,

        @Schema(name = "fabricante",
                example = "Electrolux SA"
        )
        @NotEmpty
        String fabricante,

        @Schema(name = "voltagem",
                example = "110"
        )
        @NotNull
        Integer voltagem,

        @Schema(name = "tempoUsoDiario",
                example = "2"
        )
        @NotNull
        Integer tempoUsoDiario
) {
}
