package br.com.fsales.eletrotech.dominio.eletrodomestico.repository;

import br.com.fsales.eletrotech.dominio.eletrodomestico.entitie.Eletrodomestico;
import br.com.fsales.eletrotech.dominio.eletrodomestico.projection.EletrodomesticoProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

/**
 *
 */
public interface EletrodomesticoRepository extends JpaRepository<Eletrodomestico, UUID> {

    @Query(value = """
                select
                    el.id,
                    el.nome,
                    el.modelo,
                    el.fabricante,
                    el.potencia,
                    el.voltagem,
                    el.tempo_uso_diario tempoUsoDiario,
                    p.id pId,
                    p.nome pNome,
                    p.sobrenome pSobrenome,
                    p.parentesco pParentesco,
                    parent.id   as parentId,
                    parent.nome as parentNome,
                    parent.sobrenome as parentSobrenome,
                    e.id eId,
                    e.cep eCep,
                    e.rua eRua,
                    e.complemento eComplemento,
                    e.numero eNumero,
                    e.bairro eBairro,
                    e.cidade eCidade,
                    e.estado eEstado,
                    e.nome_endereco eNomeEndereco
                from
                    eletrodomestico el
                inner join endereco e on
                    (e.id_pessoa = el.id_pessoa
                        and e.id = el.id_endereco)
                inner join pessoa p on
                    p.id = el.id_pessoa
                left join pessoa parent on
                    parent.id = p.id_parent
            """,
            nativeQuery = true)
    Page<EletrodomesticoProjection> consultarEnderecoPaginado(
            Pageable pageable
    );
}
