package br.com.fsales.eletrotech.dominio.pessoa.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

public record ListarPessoaRequest(
        @Schema(name = "nome",
                example = "Marcos"
        )
        String nome,
        @Schema(name = "sobrenome",
                example = "Andrade"
        )
        String sobrenome,
        String siglaParentesco,
        String siglaSexo,
        String cpf
) implements Serializable {
}