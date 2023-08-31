package br.com.fsales.eletrotech.dominio.pessoa.dto;

import br.com.fsales.eletrotech.dominio.endereco.entitie.Endereco;

import java.util.List;
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

        String estado
) {
    /**
     * @param endereco
     * @return
     */
    public static EnderecoResponse toEnderecoResponse(
            Endereco endereco
    ) {
        return new EnderecoResponse(
                endereco.id(),
                endereco.nomeEndereco(),
                endereco.cep(),
                endereco.rua(),
                endereco.complemento(),
                endereco.numero(),
                endereco.bairro(),
                endereco.cidade(),
                endereco.estado().nome()
        );
    }

    /**
     * @param enderecos
     * @return
     */
    public static List<EnderecoResponse> toEnderecoResponse(
            List<Endereco> enderecos
    ) {
        return enderecos
                .stream()
                .map(EnderecoResponse::toEnderecoResponse)
                .collect(Collectors.toList());
    }
}
