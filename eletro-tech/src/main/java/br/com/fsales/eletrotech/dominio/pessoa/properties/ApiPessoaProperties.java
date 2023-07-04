package br.com.fsales.eletrotech.dominio.pessoa.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "application.api-pessoa")
@Data
public class ApiPessoaProperties {

    @NestedConfigurationProperty
    private SwaggerProperties swagger;

    @Data

    public static class SwaggerProperties {

        private String name;

        private String description;
    }
}
