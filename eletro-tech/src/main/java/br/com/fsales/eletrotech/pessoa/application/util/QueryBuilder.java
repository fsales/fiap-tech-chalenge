package br.com.fsales.eletrotech.pessoa.application.util;

import br.com.fsales.eletrotech.pessoa.domain.entity.PessoaEntity;
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
    public static Example<PessoaEntity> pessoaQuery(
            PessoaEntity pessoa
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
