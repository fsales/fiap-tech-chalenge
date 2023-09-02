package br.com.fsales.eletrotech.client.viacep.dto;

import java.io.Serializable;

public record CepApiResponse(
        String cep,
        String logradouro,
        String complemento,
        String bairro,
        String localidade,
        String uf
) implements Serializable {
}
