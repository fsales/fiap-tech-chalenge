package br.com.fsales.eletrotech.dominio.eletrodomestico.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record DadosAtualizarEletrodomesticoRequest(
        @Schema(name = "id",
                example = "f6c323ed-968f-43fc-aa3a-b25a764b4d5d"
        )

        @NotNull
        UUID id,

        @Schema(name = "nome",
                example = "Microondas"
        )
        @NotEmpty
        String nome,

        @Schema(name = "modelo",
                example = "MRAS2"
        )
        @NotEmpty
        String modelo,

        @Schema(name = "potencia",
                example = "700"
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
                example = "4"
        )
        @NotNull
        Integer tempoUsoDiario
) {
}
