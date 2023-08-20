package br.com.fsales.eletrotech.dominio.endereco.dto;

import java.io.Serializable;
import java.util.UUID;

public record ListarEnderecoRequest(
        UUID idPessoa,
        String rua,
        String bairro,
        String cidade,
        String siglaEstado
) implements Serializable {

}
