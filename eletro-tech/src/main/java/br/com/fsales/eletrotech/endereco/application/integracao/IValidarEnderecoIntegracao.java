package br.com.fsales.eletrotech.endereco.application.integracao;

import java.util.UUID;

public interface IValidarEnderecoIntegracao {

    /**
     * @param id
     * @return
     */
    boolean verificarSeIdExiste(final UUID id, UUID idPessoa);
}
