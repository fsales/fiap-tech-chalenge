package br.com.fsales.eletrotech.dominio.pessoa.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest

// não utilizar o banco de dados em memória. deve ser configurado o mesmo banco utilizado pela aplicação
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

@ActiveProfiles("test")
class IPessoaRepositoryTest {

    @Autowired
    private IPessoaRepository pessoaRepository;

    @Autowired
    TestEntityManager manager;

    @Test
    @DisplayName("Consultando sem utilizar filros")
    void consultarPessoaPaginada() {
        System.out.println();
        var pageable = Pageable.ofSize(01);
        var pessoasPage = pessoaRepository.consultarPessoaPaginada(null, pageable);

        assertThat(pessoasPage.stream().toList()).isEmpty();

    }
}