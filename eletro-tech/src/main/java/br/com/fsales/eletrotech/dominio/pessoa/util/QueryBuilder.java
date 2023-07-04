package br.com.fsales.eletrotech.dominio.pessoa.util;

import br.com.fsales.eletrotech.dominio.pessoa.entitie.Pessoa;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

/**
 *
 */
public final class QueryBuilder {

    private QueryBuilder() {
    }


    /**
     * @param pessoa
     * @return
     */
    public static Example<Pessoa> pessoaQuery(
            Pessoa pessoa
    ) {

        ExampleMatcher exampleMatcher = ExampleMatcher
                .matchingAll()
                .withIgnoreCase()
                .withIgnoreNullValues();

        return Example.of(
                pessoa,
                exampleMatcher
        );
    }
}
