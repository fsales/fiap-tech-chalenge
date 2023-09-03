package br.com.fsales.eletrotech.pessoa.application.integracao;

import java.util.UUID;

public interface IValidarPessaoIntegracao {

    /**
     * @param id
     * @return
     */
    boolean verificarSeIdExiste(final UUID id);
}
