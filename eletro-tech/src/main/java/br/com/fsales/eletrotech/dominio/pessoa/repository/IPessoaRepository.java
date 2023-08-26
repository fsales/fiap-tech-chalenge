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
                    "AND (:#{#filtro?.sobrenome} IS NULL OR UPPER(pessoa.sobrenome) LIKE  CONCAT('%',upper(:#{#filtro?.sobrenome}),'%') )" +
                    "AND (:#{#filtro?.siglaSexo} IS NULL OR UPPER(pessoa.sexo) = upper(:#{#filtro?.siglaSexo}) )" +
                    "AND (:#{#filtro?.siglaParentesco} IS NULL OR UPPER(pessoa.parentesco) = upper(:#{#filtro?.siglaParentesco}) )" +
                    "AND (:#{#filtro?.cpf} IS NULL OR UPPER(pessoa.cpf) = upper(:#{#filtro?.cpf}) )"
    )
    Page<Pessoa> consultarPessoaPaginada(
            ListarPessoaRequest filtro,
            Pageable pageable
    );

    /**
     * verifica se o cpf já existe na base
     *
     * @param cpf
     * @return
     */
    boolean existsByCpf(String cpf);

    /**
     * @param cpf
     * @param id
     * @return
     */
    @Query("SELECT case when count(p)> 0 then true else false end FROM PESSOA p WHERE p.cpf = :cpf and ( :#{#id} IS NULL OR p.id <> :#{#id}) ")
    boolean existsByCpfAndIdDifference(String cpf, UUID id);
}
