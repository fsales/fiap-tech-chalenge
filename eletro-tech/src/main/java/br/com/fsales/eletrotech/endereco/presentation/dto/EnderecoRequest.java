package br.com.fsales.eletrotech.endereco.presentation.dto;

import br.com.fsales.eletrotech.endereco.presentation.validation.Estado;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.UUID;

public record EnderecoRequest(
        @Schema(name = "idPessoa",
                example = "fed3f974-3b1e-449d-bcd6-3a8450b09fb9"
        )
        @NotNull
        UUID idPessoa,
        @Schema(name = "nomeEndereco",
                example = "Minha casa"
        )
        @NotEmpty
        String nomeEndereco,
        @Schema(name = "cep",
                example = "01001000"
        )
        @NotEmpty
        @Pattern(regexp = "[0-9]{8}", message = "O CEP deve conter somente número com 8 posições")
        String cep,
        @Schema(name = "rua",
                example = "Praça da Sé"
        )
        @NotEmpty
        String rua,

        @Schema(name = "complemento",
                example = "lado ímpar"
        )
        String complemento,

        @Schema(name = "numero",
                example = "1024"
        )
        @NotNull
        Integer numero,

        @Schema(name = "bairro",
                example = "Sé"
        )
        @NotEmpty
        String bairro,

        @Schema(name = "cidade",
                example = "São Paulo"
        )
        @NotEmpty
        String cidade,

        @Schema(name = "siglaEstado",
                example = "SP"
        )
        @NotEmpty
        @Estado
        String siglaEstado
) {
}
