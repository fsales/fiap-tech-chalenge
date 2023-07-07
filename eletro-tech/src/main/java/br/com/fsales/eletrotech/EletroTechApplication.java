package br.com.fsales.eletrotech;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class EletroTechApplication {

    public static void main(String[] args) {

        //SpringApplication.run(EletroTechApplication.class, args);

        new SpringApplicationBuilder(EletroTechApplication.class)
                .build()
                .run(args);
    }

}
