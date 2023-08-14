package br.com.fsales.eletrotech.pessoa.domain.repository;

import br.com.fsales.eletrotech.pessoa.application.dto.PessoaListarDTO;
import br.com.fsales.eletrotech.pessoa.domain.entity.PessoaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IPessoaRepository extends JpaRepository<PessoaEntity, UUID> {

    /**
     * @param filtro
     * @param pageable
     * @return
     */
    @Query(
            value = """
                            SELECT pessoa FROM PESSOA pessoa
                                WHERE
                                    (:#{#filtro?.nome} IS NULL OR UPPER(pessoa.nome) LIKE  CONCAT('%',upper(:#{#filtro?.nome}),'%') )
                                AND 
                                    (:#{#filtro?.sobrenome} IS NULL OR UPPER(pessoa.sobrenome) LIKE  CONCAT('%',upper(:#{#filtro?.sobrenome}),'%') )
                                AND 
                                    (:#{#filtro?.siglaSexo} IS NULL OR UPPER(pessoa.sexo) = upper(:#{#filtro?.siglaSexo}) )
                                AND
                                    (:#{#filtro?.siglaParentesco} IS NULL OR UPPER(pessoa.parentesco) = upper(:#{#filtro?.siglaParentesco}) )
                                AND 
                                    (:#{#filtro?.cpf} IS NULL OR UPPER(pessoa.cpf) = upper(:#{#filtro?.cpf}) )
                            
                    """
    )
    Page<PessoaEntity> consultarPessoaPaginada(
            PessoaListarDTO filtro,
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
    @Query(
            value = """
                    SELECT case when count(p.id)> 0 then true else false end FROM pessoa p 
                        WHERE p.cpf = :cpf and ( cast(:#{#id} as varchar ) IS NULL OR p.id <> :#{#id})
                    """,
            nativeQuery = true
    )
    boolean existsByCpfAndIdDifference(@Param("cpf") String cpf, @Param("id") UUID id);
}
