package br.com.fsales.eletrotech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EletroTechApplication {

    public static void main(String[] args) {
        SpringApplication.run(EletroTechApplication.class, args);
    }

}
