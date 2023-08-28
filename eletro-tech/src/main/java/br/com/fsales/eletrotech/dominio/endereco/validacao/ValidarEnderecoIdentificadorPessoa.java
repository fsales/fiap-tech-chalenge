package br.com.fsales.eletrotech.dominio.endereco.validacao;

import br.com.fsales.eletrotech.dominio.endereco.validacao.exception.ValidarEnderecoException;
import br.com.fsales.eletrotech.dominio.pessoa.integracao.IValidarPessaoIntegracao;
import org.springframework.stereotype.Component;

@Component
public class ValidarEnderecoIdentificadorPessoa implements ValidarEndereco {

    private final IValidarPessaoIntegracao validarPessaoIntegracao;

    public ValidarEnderecoIdentificadorPessoa(IValidarPessaoIntegracao validarPessaoIntegracao) {
        this.validarPessaoIntegracao = validarPessaoIntegracao;
    }

    /**
     * @param endereco
     */
    @Override
    public void validar(IEndereco endereco) {
        if (validarPessaoIntegracao.verificarSeIdExiste(endereco.idPessoa()))
            throw new ValidarEnderecoException(
                    String.format(
                            "Não foi localizado a pessoa de id: %s ",
                            endereco.idPessoa()
                    )
            );


    }
}
