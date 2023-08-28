package br.com.fsales.eletrotech.dominio.endereco.integracao;

import java.util.UUID;

public interface IValidarEnderecoIntegracao {

    /**
     * @param id
     * @return
     */
    boolean verificarSeIdExiste(final UUID id);
}
