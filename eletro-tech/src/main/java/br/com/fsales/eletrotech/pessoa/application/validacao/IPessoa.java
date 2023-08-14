package br.com.fsales.eletrotech.pessoa.application.validacao;

import java.util.Collection;
import java.util.UUID;

public interface IPessoa {

    /**
     * @return
     */
    default UUID id() {
        return null;
    }

    /**
     * @return representa o numero do cpf da pessoa
     */
    String cpf();

    /**
     * @return
     */
    String nome();

    /**
     * @return
     */
    String sobrenome();


    /**
     * @return
     */
    String siglaParentesco();

    /**
     * @return
     */
    Collection<? extends IPessoa> dependentes();
}
