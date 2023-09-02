package br.com.fsales.eletrotech.endereco.application.dto;

import br.com.fsales.eletrotech.endereco.application.validacao.IEndereco;

import java.util.UUID;

public record EnderecoAtualizarDTO(
        UUID id,
        UUID idPessoa,
        String nomeEndereco,
        String cep,
        String rua,
        String complemento,
        Integer numero,
        String bairro,
        String cidade,
        String siglaEstado
) implements IEndereco {
}
