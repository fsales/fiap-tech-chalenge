package br.com.fsales.eletrotech.dominio.pessoa.dto;

import br.com.fsales.eletrotech.dominio.endereco.entitie.Endereco;

import java.util.List;
import java.util.stream.Collectors;

public record EnderecoResponse(
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
                endereco.cep(),
                endereco.getRua(),
                endereco.getComplemento(),
                endereco.getNumero(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getEstado().nome()
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
