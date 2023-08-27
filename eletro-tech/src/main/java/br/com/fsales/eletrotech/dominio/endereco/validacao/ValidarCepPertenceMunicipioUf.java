package br.com.fsales.eletrotech.dominio.endereco.validacao;

import br.com.fsales.eletrotech.dominio.endereco.validacao.exception.ValidarEnderecoException;
import br.com.fsales.eletrotech.integracao.viacep.ServicoConsultaCep;
import br.com.fsales.eletrotech.integracao.viacep.dto.CepApiResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class ValidarCepPertenceMunicipioUf implements ValidarEndereco {

    private final ServicoConsultaCep servicoConsultaCep;

    public ValidarCepPertenceMunicipioUf(ServicoConsultaCep servicoConsultaCep) {
        this.servicoConsultaCep = servicoConsultaCep;
    }

    /**
     * @param endereco
     */
    @Override
    public void validar(
            final IEndereco endereco
    ) {

        var cepApiResponse = servicoConsultaCep.consultaPorCep(endereco.cep());


        // remover separador CEP
        var cepEndereco = removeSeparadorCep(
                removeSeparadorCep(
                        endereco.cep()
                )
        );

        var cepApi = removeSeparadorCep(
                removeSeparadorCep(
                        cepApiResponse.cep()
                )
        );

        // verifica se os campos são iguais
        if (!isCepValido(
                cepEndereco,
                cepApi,
                endereco,
                cepApiResponse)
        )
            throw new ValidarEnderecoException(
                    "O CEP informado é inválido ou inexistente."
            );


    }

    private boolean isCepValido(
            String cepEndereco,
            String cepApi,
            IEndereco endereco,
            CepApiResponse cepApiResponse
    ) {
        var isCepIgual = comparar(
                cepEndereco,
                cepApi
        );

        var isCidadeIgual = comparar(
                endereco.cidade(),
                cepApiResponse.localidade()
        );

        var isEstadoIgual = comparar(
                endereco.siglaEstado(),
                cepApiResponse.uf()
        );

        return isCepIgual &&
               isCidadeIgual &&
               isEstadoIgual;
    }


    private String removeSeparadorCep(
            final String cep
    ) {
        return StringUtils.replace(
                cep,
                "-",
                ""
        );
    }

    private boolean comparar(String campoA, String campoB) {

        return StringUtils.equals(
                StringUtils.trim(
                        campoA
                )
                , StringUtils.trim(
                        campoB
                )
        );
    }
}
