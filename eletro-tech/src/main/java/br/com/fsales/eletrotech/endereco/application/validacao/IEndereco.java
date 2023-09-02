package br.com.fsales.eletrotech.endereco.application.validacao;

import java.util.UUID;

public interface IEndereco {

    default UUID idPessoa() {
        return null;
    }

    ;

    String cep();

    String cidade();

    String siglaEstado();
}
