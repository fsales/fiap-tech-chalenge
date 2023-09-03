package br.com.fsales.eletrotech.pessoa.application.dto;

import br.com.fsales.eletrotech.pessoa.application.validacao.IPessoa;

import java.time.LocalDate;
import java.util.Collection;

public record PessoaCadastroDTO(
        String nome,
        String sobrenome,
        LocalDate dataNascimento,
        String cpf,
        String siglaSexo,
        String siglaParentesco,
        Collection<PessoaCadastroDTO> dependentes
) implements IPessoa {
}
