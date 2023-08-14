package br.com.fsales.eletrotech.endereco.application.dto;

import java.time.Instant;
import java.util.UUID;

public record EnderecoDTO(

        UUID id,
        UUID idPessoa,
        String nomeEndereco,
        String cep,
        String rua,
        String complemento,
        Integer numero,
        String bairro,
        String cidade,

        String siglaEstado,
        String nomeEstado,
        Instant created,
        Instant updated
) {
}
