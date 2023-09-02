package br.com.fsales.eletrotech.endereco.presentation.dto;

import br.com.fsales.eletrotech.endereco.domain.entity.Endereco;
import br.com.fsales.eletrotech.endereco.domain.enumeration.EstadoEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
        @Schema(name = "idPessoa",
                example = "6aaefc80-b9dc-4512-bbed-6dbebe396636"
        )
        UUID idPessoa,
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

        @JsonIgnore
        @Schema(hidden = true)
        EstadoEnum estadoEnum,

        @Schema(name = "created")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        Instant created,

        @Schema(name = "updated")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        Instant updated
) {

    @JsonProperty
    @Schema(name = "nomeEstado",
            example = "Goiás"
    )
    public String nomeEstado() {
        return estadoEnum == null ? null : estadoEnum.nome();
    }

    @JsonProperty
    @Schema(name = "siglaEstado",
            example = "GO"
    )
    public String siglaEstado() {
        return estadoEnum == null ? null : estadoEnum.sigla();
    }

    /**
     * @param endereco
     * @return
     */
    public static EnderecoResponse fromEnderecoToResponse(
            Endereco endereco
    ) {

        return new EnderecoResponse(
                endereco.getId(),
                endereco.getIdPessoa(),
                endereco.getNomeEndereco(),
                endereco.getCep(),
                endereco.getRua(),
                endereco.getComplemento(),
                endereco.getNumero(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getEstado(),
                endereco.getCreated(),
                endereco.getUpdated()
        );
    }
}
