package br.com.fsales.eletrotech.dominio.eletrodomestico.dto;

import br.com.fsales.eletrotech.dominio.eletrodomestico.validacao.IEletrodomestico;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record EletrodomesticoRequest(
        @Schema(name = "idPessoa",
                example = "6aaefc80-b9dc-4512-bbed-6dbebe396636"
        )
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
) implements IEletrodomestico {
}
