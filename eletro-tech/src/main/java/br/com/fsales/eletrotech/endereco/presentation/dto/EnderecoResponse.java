package br.com.fsales.eletrotech.endereco.presentation.dto;

import br.com.fsales.eletrotech.endereco.application.dto.EnderecoDTO;
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

        @JsonProperty
        @Schema(name = "siglaEstado",
                example = "GO"
        )
        String siglaEstado,

        @JsonProperty
        @Schema(name = "nomeEstado",
                example = "Goiás"
        )
        String nomeEstado,

        @Schema(name = "created")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        Instant created,

        @Schema(name = "updated")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        Instant updated
) {
    /**
     * @param endereco
     * @return
     */
    public static EnderecoResponse fromEnderecoToResponse(
            EnderecoDTO endereco
    ) {

        return new EnderecoResponse(
                endereco.id(),
                endereco.idPessoa(),
                endereco.nomeEndereco(),
                endereco.cep(),
                endereco.rua(),
                endereco.complemento(),
                endereco.numero(),
                endereco.bairro(),
                endereco.cidade(),
                endereco.siglaEstado(),
                endereco.nomeEstado(),
                endereco.created(),
                endereco.updated()
        );
    }
}
