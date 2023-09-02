package br.com.fsales.eletrotech.endereco.presentation.dto;

import br.com.fsales.eletrotech.endereco.application.validacao.IEndereco;
import br.com.fsales.eletrotech.endereco.presentation.controller.validation.Estado;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.UUID;

public record DadosAtualizarEnderecoRequest(
        @Schema(name = "id",
                example = "f6c323ed-968f-43fc-aa3a-b25a764b4d5d"
        )
        @NotNull
        UUID id,
        @NotNull
        @Schema(name = "idPessoa",
                example = "6aaefc80-b9dc-4512-bbed-6dbebe396636"
        )
        UUID idPessoa,
        @NotEmpty
        String nomeEndereco,
        @NotEmpty
        @Pattern(regexp = "[0-9]{8}", message = "O CEP deve conter somente número com 8 posições")
        String cep,
        @NotEmpty
        String rua,

        String complemento,

        @NotNull
        Integer numero,

        @NotEmpty
        String bairro,

        @NotEmpty
        String cidade,

        @NotEmpty
        @Estado
        String siglaEstado
) implements IEndereco {
}
