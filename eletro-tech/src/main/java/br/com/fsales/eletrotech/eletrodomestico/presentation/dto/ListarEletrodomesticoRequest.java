package br.com.fsales.eletrotech.eletrodomestico.presentation.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record ListarEletrodomesticoRequest(
        @Schema(name = "nome",
                example = "Microondas"
        )
        String nome,
        @Schema(name = "modelo",
                example = "MRAS2"
        )
        String modelo,
        @Schema(name = "fabricante",
                example = "Electrolux"
        )
        String fabricante,
        @Schema(name = "potencia",
                example = "700"
        )
        Integer potencia
) {
}