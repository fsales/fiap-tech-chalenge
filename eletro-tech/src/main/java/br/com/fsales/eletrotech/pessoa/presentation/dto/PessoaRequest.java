package br.com.fsales.eletrotech.pessoa.presentation.dto;

import br.com.fsales.eletrotech.pessoa.presentation.openapi.Swagger;
import br.com.fsales.eletrotech.pessoa.presentation.validation.Parentesco;
import br.com.fsales.eletrotech.pessoa.presentation.validation.Sexo;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.Collection;

public record PessoaRequest(
        @Schema(name = "nome",
                example = "Marcos Andre"
        )
        @NotBlank
        String nome,
        @Schema(name = "sobrenome",
                example = "Andrade"
        )
        @NotBlank
        String sobrenome,

        @Schema(name = "dataNascimento",
                pattern = "dd/MM/yyyy",
                example = "17/02/1995",
                type = "string"
        )
        @JsonFormat(pattern = "dd/MM/yyyy")
        @Past
        @NotNull
        LocalDate dataNascimento,

        @Schema(name = "cpf",
                example = "50297831054"
        )
        @CPF
        @NotBlank
        String cpf,

        @Schema(name = "siglaSexo",
                example = "M",
                description = "Valores possíveis: M (Masculino), F (Feminino) ou O (Outros)"
        )
        @NotNull
        @Sexo
        String siglaSexo,

        @Schema(name = "siglaParentesco",
                example = "F",
                description = "Valores possíveis: P (Pai), M (Mãe), I (Irmão(a)), F (Filho(a)) ou O (Outros)"
        )

        @Parentesco
        String siglaParentesco,

        @Schema(name = "dependentes",
                implementation = PessoaRequest.class,
                example = Swagger.API_PESSOA_OPERATION_JSON_DEPENDENTES
        )

        @Valid
        Collection<PessoaRequest> dependentes
) {

}