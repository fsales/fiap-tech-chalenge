package br.com.fsales.eletrotech.pessoa.presentation.dto;

import br.com.fsales.eletrotech.pessoa.presentation.validation.Parentesco;
import br.com.fsales.eletrotech.pessoa.presentation.validation.Sexo;
import io.swagger.v3.oas.annotations.media.Schema;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;

public record ListarPessoaRequest(
        @Schema(name = "nome",
                example = "Maria"
        )
        String nome,
        @Schema(name = "sobrenome",
                example = "Silva de Castro"
        )
        String sobrenome,

        @Schema(name = "siglaParentesco",
                example = "F"
        )
        @Parentesco
        String siglaParentesco,

        @Schema(name = "siglaSexo",
                description = "M ou F",
                example = "F"
        )
        @Sexo
        String siglaSexo,

        @Schema(name = "cpf",
                description = "Número de CPF válido",
                example = "64630752056"

        )
        @CPF
        String cpf
) implements Serializable {
}