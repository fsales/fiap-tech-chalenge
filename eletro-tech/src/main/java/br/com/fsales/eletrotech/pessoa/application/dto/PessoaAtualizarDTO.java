package br.com.fsales.eletrotech.pessoa.application.dto;

import br.com.fsales.eletrotech.pessoa.application.validacao.IPessoa;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Collection;
import java.util.UUID;

public record PessoaAtualizarDTO(
        @NotNull
        UUID id,
        String nome,
        String sobrenome,
        LocalDate dataNascimento,
        String cpf,
        String siglaSexo,
        String siglaParentesco,

        Collection<PessoaAtualizarDTO> dependentes
) implements IPessoa {
}
