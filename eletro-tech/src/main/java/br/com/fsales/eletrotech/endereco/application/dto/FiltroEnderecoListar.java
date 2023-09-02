package br.com.fsales.eletrotech.endereco.application.dto;

import java.util.UUID;

public record FiltroEnderecoListar(
        UUID idPessoa,
        String rua,
        String bairro,
        String cidade,
        String siglaEstado
) {
}
