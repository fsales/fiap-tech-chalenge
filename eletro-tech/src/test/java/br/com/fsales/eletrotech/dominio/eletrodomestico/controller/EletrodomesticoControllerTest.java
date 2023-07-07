package br.com.fsales.eletrotech.dominio.eletrodomestico.controller;

import br.com.fsales.eletrotech.dominio.eletrodomestico.dto.EletrodomesticoRequest;
import br.com.fsales.eletrotech.dominio.eletrodomestico.dto.EletrodomesticoResponse;
import br.com.fsales.eletrotech.dominio.eletrodomestico.entitie.Eletrodomestico;
import br.com.fsales.eletrotech.dominio.eletrodomestico.service.EletrodomesticoService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class EletrodomesticoControllerTest {


    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<EletrodomesticoRequest> dadosRequestJson;

    @Autowired
    private JacksonTester<EletrodomesticoResponse> dadosResponseJson;

    @MockBean
    private EletrodomesticoService eletrodomesticoService;

    @Test
    @DisplayName("Cadastrar Eletrodomestico - Status code 400")
    void cadastrarCenario01() throws Exception {

        var response = mvc.perform(
                post("/eletrodomesticos")

        ).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Cadastrar Eletrodomestico - Status code 200")
    void cadastrarCenario02() throws Exception {

        when(eletrodomesticoService.cadastrar(any())).thenReturn(
                new Eletrodomestico(
                        null,
                        "Som",
                        "CX410",
                        200,
                        "Sony",
                        220,
                        1
                )
        );


        var response = mvc.perform(
                post("/eletrodomesticos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                dadosRequestJson.write(
                                        new EletrodomesticoRequest(
                                                "Som",
                                                "CX410",
                                                200,
                                                "Sony",
                                                220,
                                                1
                                        )
                                ).getJson()
                        )

        ).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());


        var jsonEsperado = dadosResponseJson.write(
                new EletrodomesticoResponse(
                        null,
                        "Som",
                        "CX410",
                        200,
                        "Sony",
                        220,
                        1,
                        null,
                        null
                )
        ).getJson();

        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
    }
}