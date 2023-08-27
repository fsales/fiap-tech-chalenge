package br.com.fsales.eletrotech.integracao.feign.config;


import feign.Retryer;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import java.util.concurrent.TimeUnit;

@Import(FeignClientsConfiguration.class)
public class ViaCepClientFeignConfiguration {
    @Bean
    public Retryer feignRetryer() {
        return new Retryer.Default(100, TimeUnit.SECONDS.toMillis(1), 2);
    }
}
