package br.com.fsales.eletrotech.eletrodomestico.presentation.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record ListarEletrodomesticoRequest(
        @Schema(name = "nome",
                example = "Chuveiro Elétrico"
        )
        String nome,
        @Schema(name = "modelo",
                example = "MT30S"
        )
        String modelo,
        @Schema(name = "fabricante",
                example = "LORENZETTI"
        )
        String fabricante,
        @Schema(name = "potencia",
                example = "7800"
        )
        Integer potencia
) {
}