package br.com.fsales.eletrotech.dominio.pessoa.repository;

import br.com.fsales.eletrotech.dominio.pessoa.dto.ListarPessoaRequest;
import br.com.fsales.eletrotech.dominio.pessoa.entitie.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IPessoaRepository extends JpaRepository<Pessoa, UUID> {

    /**
     * @param filtro
     * @param pageable
     * @return
     */
    @Query(
            "SELECT pessoa FROM PESSOA pessoa LEFT JOIN FETCH pessoa.dependentes dependentes " +
                    "WHERE (:#{#filtro?.nome} IS NULL OR UPPER(pessoa.nome) LIKE  CONCAT('%',upper(:#{#filtro?.nome}),'%') )" +
                    "AND (:#{#filtro?.sobrenome} IS NULL OR UPPER(pessoa.sobrenome) LIKE  CONCAT('%',upper(:#{#filtro?.sobrenome}),'%') )"

    )
    Page<Pessoa> consultarPessoaPaginada(
            ListarPessoaRequest filtro,
            Pageable pageable
    );
}
