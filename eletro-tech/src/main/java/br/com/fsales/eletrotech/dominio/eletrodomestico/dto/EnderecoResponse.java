package br.com.fsales.eletrotech.dominio.eletrodomestico.dto;

import br.com.fsales.eletrotech.dominio.endereco.enumeration.EstadoEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.Instant;
import java.util.UUID;


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
        String siglaEstado
) {

    @JsonProperty
    @Schema(name = "nomeEstado",
            example = "Goiás"
    )
    public String nomeEstado() {
        var estadoEnum = EstadoEnum.getEnum(siglaEstado());
        return estadoEnum == null ? null : estadoEnum.nome();
    }

}
