package br.com.fsales.eletrotech.client.viacep;

import br.com.fsales.eletrotech.client.viacep.client.ViaCepApiClient;
import br.com.fsales.eletrotech.client.viacep.dto.CepApiResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class ServicoConsultaCepImpl implements ServicoConsultaCep {

    private final ViaCepApiClient viaCepApiClient;

    public ServicoConsultaCepImpl(ViaCepApiClient viaCepApiClient) {
        this.viaCepApiClient = viaCepApiClient;
    }

    /**
     * @param cep
     * @return
     */
    @Override
    public CepApiResponse consultaPorCep(final String cep) {

        if (StringUtils.isBlank(cep))
            throw new IllegalArgumentException("Cep é obrigatório");
        return viaCepApiClient.consultaPorCep(cep);
    }
}
