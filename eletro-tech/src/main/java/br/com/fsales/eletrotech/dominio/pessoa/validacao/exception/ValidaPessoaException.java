package br.com.fsales.eletrotech.dominio.pessoa.validacao.exception;

import br.com.fsales.eletrotech.infrastructure.exception.EletroTechNegocioException;

public class ValidaPessoaException extends EletroTechNegocioException {

    public ValidaPessoaException() {
    }

    public ValidaPessoaException(String message) {
        super(message);
    }
}