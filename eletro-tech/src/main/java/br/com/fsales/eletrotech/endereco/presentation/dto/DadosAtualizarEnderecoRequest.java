package br.com.fsales.eletrotech.endereco.presentation.dto;

import br.com.fsales.eletrotech.endereco.application.validacao.IEndereco;
import br.com.fsales.eletrotech.endereco.presentation.validation.Estado;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.UUID;

public record DadosAtualizarEnderecoRequest(
        @Schema(name = "id",
                example = "d86a5f0d-3145-496c-bc9c-1eff2ad89fca"
        )
        @NotNull
        UUID id,
        @NotNull
        @Schema(name = "idPessoa",
                example = "608f3f7d-67da-4ea6-ba56-55d9a3721dd2"
        )
        UUID idPessoa,
        @Schema(name = "nomeEndereco",
                example = "Minha casa"
        )
        @NotEmpty
        String nomeEndereco,
        @Schema(name = "cep",
                example = "91040000"
        )
        @NotEmpty
        @Pattern(regexp = "[0-9]{8}", message = "O CEP deve conter somente número com 8 posições")
        String cep,
        @Schema(name = "rua",
                example = "Rua Domingos Rubbo"
        )
        @NotEmpty
        String rua,

        @Schema(name = "complemento",
                example = "BL 16"
        )
        String complemento,

        @Schema(name = "numero",
                example = "35"
        )
        @NotNull
        Integer numero,

        @Schema(name = "bairro",
                example = "Cristo Redentor"
        )
        @NotEmpty
        String bairro,
        @Schema(name = "cidade",
                example = "Porto Alegre"
        )
        @NotEmpty
        String cidade,
        @Schema(name = "siglaEstado",
                example = "RS"
        )
        @NotEmpty
        @Estado
        String siglaEstado
) implements IEndereco {
}
