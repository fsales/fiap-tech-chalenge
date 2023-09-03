package br.com.fsales.eletrotech.endereco.application.dto;

import java.time.Instant;
import java.util.UUID;

public record EnderecoListarDTO(
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
        EnderecoListarDTO.PessoaResponse pessoa,
        Instant created,
        Instant updated
) {

    public record PessoaResponse(
            UUID idPessoa,
            String nome,
            String sobrenome,
            EnderecoListarDTO.PessoaResponse parent,
            String parentesco,
            String tipoPessoa
    ) {
    }
}
