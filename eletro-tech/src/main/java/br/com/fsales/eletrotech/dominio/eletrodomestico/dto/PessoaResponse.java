package br.com.fsales.eletrotech.dominio.eletrodomestico.dto;

import br.com.fsales.eletrotech.dominio.pessoa.enumeration.ParentescoEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

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

        @JsonIgnore
        String parentesco
) {
    @JsonProperty
    @Schema(name = "parentesco",
            example = "FILHO"
    )
    public String parentesco() {
        var parentescoEnum = ParentescoEnum.getEnum(parentesco);

        return parentescoEnum == null ? null : parentescoEnum.getDescricao();
    }
}
