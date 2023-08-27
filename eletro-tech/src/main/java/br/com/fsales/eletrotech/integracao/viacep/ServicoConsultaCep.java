package br.com.fsales.eletrotech.integracao.viacep;

import br.com.fsales.eletrotech.integracao.viacep.dto.CepApiResponse;

public interface ServicoConsultaCep {

    /**
     * @param cep
     * @return
     */
    CepApiResponse consultaPorCep(final String cep);
}
