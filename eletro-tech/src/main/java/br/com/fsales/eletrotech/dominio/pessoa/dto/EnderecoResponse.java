package br.com.fsales.eletrotech.dominio.pessoa.dto;

import br.com.fsales.eletrotech.endereco.domain.entity.EnderecoEntity;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public record EnderecoResponse(
        UUID id,
        String nomeEndereco,
        String cep,

        String rua,

        String complemento,

        Integer numero,

        String bairro,

        String cidade,

        String nomeEstado,

        String siglaEstado
) {
    /**
     * @param endereco
     * @return
     */
    public static EnderecoResponse toEnderecoResponse(
            EnderecoEntity endereco
    ) {
        return new EnderecoResponse(
                endereco.getId(),
                endereco.getNomeEndereco(),
                endereco.getCep(),
                endereco.getRua(),
                endereco.getComplemento(),
                endereco.getNumero(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getNomeEstado(),
                endereco.getSiglaEstado()
        );
    }

    /**
     * @param enderecos
     * @return
     */
    public static Set<EnderecoResponse> toEnderecoResponse(
            Set<EnderecoEntity> enderecos
    ) {
        return enderecos
                .stream()
                .map(EnderecoResponse::toEnderecoResponse)
                .collect(Collectors.toSet());
    }
}
