package br.com.fsales.eletrotech.dominio.eletrodomestico.validacao;


import br.com.fsales.eletrotech.dominio.endereco.validacao.exception.ValidarEnderecoException;
import br.com.fsales.eletrotech.dominio.pessoa.integracao.IValidarPessaoIntegracao;
import org.springframework.stereotype.Component;

@Component
public class ValidarEletrodomesticoIdentificadorPessoa implements ValidarEletrodomestico {
    private final IValidarPessaoIntegracao validarPessaoIntegracao;

    public ValidarEletrodomesticoIdentificadorPessoa(IValidarPessaoIntegracao validarPessaoIntegracao) {
        this.validarPessaoIntegracao = validarPessaoIntegracao;
    }

    /**
     * @param eletrodomestico
     */
    @Override
    public void validar(final IEletrodomestico eletrodomestico) {

        if (!validarPessaoIntegracao.verificarSeIdExiste(eletrodomestico.idPessoa()))
            throw new ValidarEnderecoException(
                    String.format(
                            "Não foi localizado a pessoa de id: %s ",
                            eletrodomestico.idPessoa()
                    )
            );
    }
}
