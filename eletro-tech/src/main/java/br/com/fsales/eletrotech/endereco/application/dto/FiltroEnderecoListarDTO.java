package br.com.fsales.eletrotech.endereco.application.dto;

import java.util.UUID;

public record FiltroEnderecoListarDTO(
        UUID idPessoa,
        String rua,
        String bairro,
        String cidade,
        String siglaEstado
) {
}
