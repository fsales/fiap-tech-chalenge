package br.com.fsales.eletrotech.dominio.pessoa.dto;

import br.com.fsales.eletrotech.dominio.pessoa.controller.openapi.Swagger;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.Instant;
import java.time.LocalDate;
import java.util.*;


public record PessoaResponse(

        @Schema(name = "id",
                example = "f6c323ed-968f-43fc-aa3a-b25a764b4d5d"
        )
        UUID id,
        @Schema(name = "nome",
                example = "Marcos Andre"
        )
        String nome,
        @Schema(name = "sobrenome",
                example = "Andrade"
        )
        String sobrenome,

        @Schema(name = "dataNascimento",
                pattern = "dd/MM/yyyy",
                example = "17/02/2020",
                type = "string"
        )
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataNascimento,
        @Schema(name = "cpf",
                example = "50297831054"
        )
        String cpf,

        @Schema(name = "parent",
                implementation = PessoaResponse.class,
                example = Swagger.API_PESSOA_OPERATION_JSON_PESSOA_PARENT
        )
        @JsonInclude(JsonInclude.Include.NON_NULL)
        PessoaResponse parent,

        @Schema(name = "created")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        Instant created,

        @Schema(name = "updated")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        Instant updated,

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        @Schema(name = "dependentes",
                implementation = PessoaResponse.class,
                example = Swagger.API_PESSOA_OPERATION_JSON_DEPENDENTES
        )

        Collection<PessoaResponse> dependentes,

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        @Schema(name = "enderecos", anyOf = EnderecoResponse.class)
        Set<EnderecoResponse> enderecos,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonProperty
        @Schema(name = "descricaoParentesco",
                example = "Mãe"
        )
        String descricaoParentesco,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonProperty
        @Schema(name = "siglaParentesco",
                example = "M"
        )
        String siglaParentesco,

        @JsonProperty
        @Schema(name = "tipoPessoa",
                example = "Titular"
        )
        String tipoPessoa,

        @JsonProperty
        @Schema(name = "sexo",
                example = "MASCULINO"
        )
        String sexoDescricao
) {

    public PessoaResponse(UUID id, String nome, String sobrenome, LocalDate dataNascimento, String cpf,
                          PessoaResponse parent, Instant created, Instant updated,
                          Collection<PessoaResponse> dependentes, Set<EnderecoResponse> enderecos,
                          String descricaoParentesco, String siglaParentesco, String tipoPessoa, String sexoDescricao) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.parent = parent;
        this.dependentes = dependentes;
        this.created = created;
        this.updated = updated;
        this.enderecos = enderecos;
        this.descricaoParentesco = descricaoParentesco;
        this.siglaParentesco = siglaParentesco;
        this.tipoPessoa = tipoPessoa;
        this.sexoDescricao = sexoDescricao;
    }

    public PessoaResponse(UUID id, String nome, String sobrenome, LocalDate dataNascimento, String cpf, PessoaResponse parent,
                          Instant created, Instant updated, Collection<PessoaResponse> dependentes,
                          String descricaoParentesco, String siglaParentesco, String tipoPessoa, String sexoDescricao) {

        this(id, nome, sobrenome, dataNascimento, cpf, parent, created, updated, dependentes, new LinkedHashSet<>(),
                descricaoParentesco, siglaParentesco, tipoPessoa, sexoDescricao);
    }

    public PessoaResponse(UUID id, String nome, String sobrenome, LocalDate dataNascimento,
                          String cpf, Instant created, Instant updated,
                          String descricaoParentesco, String siglaParentesco, String tipoPessoa, String sexoDescricao) {
        this(id, nome, sobrenome, dataNascimento, cpf, null, created, updated, new ArrayList<>(), new LinkedHashSet<>(),
                descricaoParentesco, siglaParentesco, tipoPessoa, sexoDescricao);
    }

}
