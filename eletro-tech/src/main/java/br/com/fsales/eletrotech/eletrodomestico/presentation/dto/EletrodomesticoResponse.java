package br.com.fsales.eletrotech.eletrodomestico.presentation.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.Instant;
import java.util.UUID;

public record EletrodomesticoResponse(
        @Schema(name = "id",
                example = "f6c323ed-968f-43fc-aa3a-b25a764b4d5d"
        )
        UUID id,
        @Schema(name = "idPessoa",
                example = "6aaefc80-b9dc-4512-bbed-6dbebe396636"
        )
        @JsonInclude(JsonInclude.Include.NON_NULL)
        UUID idPessoa,
        @Schema(name = "idEndereco",
                example = "4bc6b235-84ae-40fe-8930-0ee0530fc170"
        )
        @JsonInclude(JsonInclude.Include.NON_NULL)
        UUID idEndereco,

        @Schema(name = "nome",
                example = "Microondas"
        )
        String nome,

        @Schema(name = "modelo",
                example = "MRAS2"
        )
        String modelo,

        @Schema(name = "potencia",
                example = "700"
        )
        Integer potencia,

        @Schema(name = "fabricante",
                example = "Electrolux"
        )
        String fabricante,

        @Schema(name = "voltagem",
                example = "220"
        )
        Integer voltagem,

        @Schema(name = "tempoUsoDiario",
                example = "4"
        )
        Integer tempoUsoDiario,

        @JsonProperty
        @Schema(name = "consumo",
                example = "60 kwh/mês",
                description = "o consumo em kWh do equipamento por dia"
        )
        ConsumoResposta consumo,

        @Schema(name = "created")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        Instant created,
        @Schema(name = "updated")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        Instant updated,
        @Schema(name = "pessoa",
                implementation = PessoaResponse.class,
                anyOf = {PessoaResponse.class}
        )
        PessoaResponse pessoa,
        @Schema(name = "endereco",
                implementation = EnderecoResponse.class,
                anyOf = {EnderecoResponse.class}
        )

        EnderecoResponse endereco
) {


        @JsonInclude(JsonInclude.Include.NON_NULL)
        public record ConsumoResposta(
                @JsonProperty
                @Schema(name = "watt",
                        example = "60",
                        description = "valor de consumo mensal"
                )
                Integer watt,
                @JsonProperty
                @Schema(name = "unidadeMedida",
                        example = "60 kwh/mês",
                        description = "unidade de medida"
                )
                String unidadeMedida
        ) {

    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record EnderecoResponse(

            @Schema(name = "id",
                    example = "f6c323ed-968f-43fc-aa3a-b25a764b4d5d"
            )
            UUID id,
            @Schema(name = "nomeEndereco",
                    example = "Minha Casa"
            )
            String nomeEndereco,
            @Schema(name = "cep",
                    example = "99999999"
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

            @Schema(name = "created")
            @JsonInclude(JsonInclude.Include.NON_NULL)
            Instant created,

            @Schema(name = "updated")
            @JsonInclude(JsonInclude.Include.NON_NULL)
            Instant updated,

            @JsonProperty
            @Schema(name = "siglaEstado",
                    example = "GO"
            )
            String siglaEstado,
            @JsonProperty
            @Schema(name = "nomeEstado",
                    example = "Goiás"
            )
            String nomeEstado
    ) {

    }


    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record ParentResponse(
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
                    implementation = ParentResponse.class,
                    anyOf = {ParentResponse.class}
            )
            @JsonInclude(JsonInclude.Include.NON_NULL)
            ParentResponse parent
    ) {
    }

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
            @Schema(name = "descricaoParentesco",
                    example = "Mãe"
            )
            String descricaoParentesco,
            @JsonProperty
            @Schema(name = "siglaParentesco",
                    example = "M"
            )
            String siglaParentesco,

            @JsonProperty
            @Schema(name = "tipoPessoa",
                    example = "Titular"
            )
            String tipoPessoa
    ) {
    }
}
