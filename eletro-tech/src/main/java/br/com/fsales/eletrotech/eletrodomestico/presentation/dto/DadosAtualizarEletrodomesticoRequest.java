package br.com.fsales.eletrotech.eletrodomestico.presentation.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record DadosAtualizarEletrodomesticoRequest(
        @Schema(name = "id",
                example = "71a0c60b-2da6-47c2-8402-51ef163f96bf"
        )

        @NotNull
        UUID id,
        @NotNull
        UUID idPessoa,
        @Schema(name = "idEndereco",
                example = "4bc6b235-84ae-40fe-8930-0ee0530fc170"
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
                example = "8"
        )
        @NotNull
        Integer tempoUsoDiario
) {
}
