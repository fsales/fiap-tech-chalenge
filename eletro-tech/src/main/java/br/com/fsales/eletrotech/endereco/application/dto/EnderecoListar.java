package br.com.fsales.eletrotech.endereco.application.dto;

import java.time.Instant;
import java.util.UUID;

public record EnderecoListar(
        UUID id,
        String nomeEndereco,
        String cep,
        String rua,
        String complemento,
        Integer numero,
        String bairro,
        String cidade,
        String siglaEstado,
        String nomeEstado,
        EnderecoListar.PessoaResponse pessoa,
        Instant created,
        Instant updated
) {

    public record PessoaResponse(
            UUID idPessoa,
            String nome,
            String sobrenome,
            EnderecoListar.PessoaResponse parent,
            String parentesco,
            String tipoPessoa
    ) {
    }
}
