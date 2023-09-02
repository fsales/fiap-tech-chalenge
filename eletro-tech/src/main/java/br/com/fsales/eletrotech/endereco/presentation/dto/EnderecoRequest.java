package br.com.fsales.eletrotech.endereco.presentation.dto;

import br.com.fsales.eletrotech.endereco.application.validacao.IEndereco;
import br.com.fsales.eletrotech.endereco.presentation.controller.validation.Estado;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.UUID;

public record EnderecoRequest(
        @NotNull
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
