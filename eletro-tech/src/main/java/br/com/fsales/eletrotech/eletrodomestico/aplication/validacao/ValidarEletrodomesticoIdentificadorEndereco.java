package br.com.fsales.eletrotech.eletrodomestico.aplication.validacao;


import br.com.fsales.eletrotech.endereco.application.integracao.IValidarEnderecoIntegracao;
import br.com.fsales.eletrotech.endereco.application.validacao.exception.ValidarEnderecoException;
import org.springframework.stereotype.Component;

@Component
public class ValidarEletrodomesticoIdentificadorEndereco implements ValidarEletrodomestico {

    private final IValidarEnderecoIntegracao validarEnderecoIntegracao;

    public ValidarEletrodomesticoIdentificadorEndereco(IValidarEnderecoIntegracao validarEnderecoIntegracao) {
        this.validarEnderecoIntegracao = validarEnderecoIntegracao;
    }

    /**
     * @param eletrodomestico
     */
    @Override
    public void validar(final IEletrodomestico eletrodomestico) {
        if (
                !validarEnderecoIntegracao.verificarSeIdExiste(
                        eletrodomestico.idEndereco(),
                        eletrodomestico.idPessoa()
                )
        )
            throw new ValidarEnderecoException(
                    String.format(
                            "Não foi localizado o endereço de id: %s idPessoa: %s ",
                            eletrodomestico.idEndereco(),
                            eletrodomestico.idPessoa()
                    )
            );
    }
}
