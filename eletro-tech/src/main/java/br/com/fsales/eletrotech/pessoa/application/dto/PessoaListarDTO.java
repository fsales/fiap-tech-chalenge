package br.com.fsales.eletrotech.pessoa.application.dto;

public record PessoaListarDTO(
        String nome,
        String sobrenome,
        String siglaParentesco,
        String siglaSexo,
        String cpf
) {
}
