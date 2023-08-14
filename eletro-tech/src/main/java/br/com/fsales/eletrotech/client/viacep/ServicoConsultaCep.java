package br.com.fsales.eletrotech.client.viacep;

import br.com.fsales.eletrotech.client.viacep.dto.CepApiResponse;

public interface ServicoConsultaCep {

    /**
     * @param cep
     * @return
     */
    CepApiResponse consultaPorCep(final String cep);
}
