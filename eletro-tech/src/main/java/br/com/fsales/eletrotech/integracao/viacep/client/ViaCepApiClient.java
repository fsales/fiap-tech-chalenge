package br.com.fsales.eletrotech.integracao.viacep.client;

import br.com.fsales.eletrotech.integracao.feign.config.ViaCepClientFeignConfiguration;
import br.com.fsales.eletrotech.integracao.viacep.dto.CepApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "ceps",
        primary = false,
        contextId = "cepClient",
        url = "${application.client.viacep.host}",
        configuration = ViaCepClientFeignConfiguration.class
)
public interface ViaCepApiClient {

    @GetMapping(value = "/{cep}/json/",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    CepApiResponse consultaPorCep(@PathVariable("cep") String cep);
}
