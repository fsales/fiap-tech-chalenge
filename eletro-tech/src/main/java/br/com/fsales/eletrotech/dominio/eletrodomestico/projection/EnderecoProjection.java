package br.com.fsales.eletrotech.dominio.eletrodomestico.projection;

import java.util.UUID;

public record EnderecoProjection(
        UUID id,
        String cep,
        String rua,
        String complemento,
        String numero,
        String bairro,
        String cidade,
        String siglaEstado,

        String nomeEndereco
) {
}
