package br.com.fsales.eletrotech.dominio.pessoa.validacao;

import br.com.fsales.eletrotech.dominio.pessoa.dto.IPessoa;

import java.util.Collection;
import java.util.List;

public interface ValidarPessoa {

    /**
     * @param pessoa
     */
    default void validar(IPessoa pessoa) {
        validar(List.of(pessoa));
    }

    /**
     * @param pessoas
     */
    void validar(Collection<? extends IPessoa> pessoas);
}
