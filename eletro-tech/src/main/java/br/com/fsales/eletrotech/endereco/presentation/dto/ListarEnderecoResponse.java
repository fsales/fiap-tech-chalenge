package br.com.fsales.eletrotech.endereco.presentation.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.Instant;
import java.util.UUID;

public record ListarEnderecoResponse(

        @Schema(name = "id",
                example = "f6c323ed-968f-43fc-aa3a-b25a764b4d5d"
        )
        UUID id,
        @Schema(name = "nomeCep",
                example = "Minha Casa"
        )
        String nomeEndereco,
        @Schema(name = "cep",
                example = "71200020"
        )
        String cep,

        @Schema(name = "rua",
                example = "Rua quatro"
        )
        String rua,

        @Schema(name = "complemento",
                example = "Bloco 16"
        )
        String complemento,

        @Schema(name = "numero",
                example = "1"
        )
        Integer numero,

        @Schema(name = "bairro",
                example = "Morada Nova"
        )
        String bairro,

        @Schema(name = "cidade",
                example = "Goiânia"
        )
        String cidade,

        @JsonProperty
        @Schema(name = "nomeEstado",
                example = "Goiás"
        )
        String nomeEstado,

        @JsonProperty
        @Schema(name = "siglaEstado",
                example = "GO"
        )
        String siglaEstado,
        @Schema(name = "pessoa",
                implementation = PessoaResponse.class,
                anyOf = {PessoaResponse.class}
        )
        PessoaResponse pessoa,

        @Schema(name = "created")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        Instant created,

        @Schema(name = "updated")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        Instant updated
) {


    /****************************************/

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record PessoaResponse(
            @Schema(name = "id",
                    example = "f6c323ed-968f-43fc-aa3a-b25a764b4d5d"
            )
            UUID idPessoa,
            @Schema(name = "nome",
                    example = "Marcos Andre"
            )
            String nome,
            @Schema(name = "sobrenome",
                    example = "Andrade"
            )
            String sobrenome,
            @Schema(name = "parent",
                    implementation = PessoaResponse.class,
                    anyOf = {PessoaResponse.class}
            )
            PessoaResponse parent,

            @JsonProperty
            @Schema(name = "parentesco",
                    example = "FILHO"
            )
            String parentesco,

            @JsonProperty
            @Schema(name = "tipoPessoa",
                    description = "Titular ou Dependente",
                    example = "Titular"
            )
            String tipoPessoa
    ) {
    }
}
