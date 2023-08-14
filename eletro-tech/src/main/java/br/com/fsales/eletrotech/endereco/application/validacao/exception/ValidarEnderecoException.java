package br.com.fsales.eletrotech.endereco.application.validacao.exception;

import br.com.fsales.eletrotech.infrastructure.exception.EletroTechNegocioException;

public class ValidarEnderecoException extends EletroTechNegocioException {
    public ValidarEnderecoException(String message) {
        super(message);
    }
}
