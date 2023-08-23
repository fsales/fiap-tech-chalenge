package br.com.fsales.eletrotech.dominio.endereco.dto;

import br.com.fsales.eletrotech.dominio.endereco.enumeration.EstadoEnum;
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

        @Schema(name = "id identificador da pessoa",
                example = "84f24cf4-6076-4324-8ddb-29be0656c206"
        )
        UUID idPessoa,

        @Schema(name = "nome da pessoa",
                example = "Marcos"
        )
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String nome,

        @Schema(name = "sobrenome da pessoa",
                example = "Andrade"
        )
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String sobrenome,

        @Schema(name = "id do responsável pelos grupo familiar",
                example = "Andrade"
        )
        @JsonInclude(JsonInclude.Include.NON_NULL)
        UUID idTitular,
        @Schema(name = "nome do responsável pelos grupo familiar",
                example = "José"
        )
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String nomeTitular,

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

    public EnderecoResponse(UUID id, UUID idPessoa, String nome, String sobrenome, UUID idTitular, String nomeTitular, String cep, String rua, String complemento, Integer numero, String bairro, String cidade, EstadoEnum estadoEnum, Instant created, Instant updated) {
        this.id = id;
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idTitular = idTitular;
        this.nomeTitular = nomeTitular;
        this.cep = cep;
        this.rua = rua;
        this.complemento = complemento;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estadoEnum = estadoEnum;
        this.created = created;
        this.updated = updated;
    }

    public EnderecoResponse(UUID id, UUID idPessoa, String cep, String rua, String complemento, Integer numero, String bairro, String cidade, EstadoEnum estadoEnum, Instant created, Instant updated) {
        this(id, idPessoa, null, null, null, null, cep, rua, complemento, numero, bairro, cidade, estadoEnum, created, updated);
    }

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
}
