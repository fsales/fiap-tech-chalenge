package br.com.fsales.eletrotech.dominio.endereco.controller;

import br.com.fsales.eletrotech.dominio.endereco.dto.EnderecoResponse;
import br.com.fsales.eletrotech.dominio.endereco.entitie.Endereco;

/**
 *
 */
public final class EnderecoDtoMapper {

    private EnderecoDtoMapper() {
    }

    /**
     * @param endereco
     * @return
     */
    public static EnderecoResponse fromEnderecoToResponse(
            Endereco endereco
    ) {

        return new EnderecoResponse(
                endereco.getId(),
                endereco.getPessoa().getId(),
                endereco.cep(),
                endereco.getRua(),
                endereco.getComplemento(),
                endereco.getNumero(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getEstado(),
                endereco.getCreated(),
                endereco.getUpdated()
        );
    }
}
