package br.com.fsales.eletrotech.dominio.endereco.repository;

import br.com.fsales.eletrotech.dominio.endereco.dto.ListarEnderecoRequest;
import br.com.fsales.eletrotech.dominio.endereco.entitie.Endereco;
import br.com.fsales.eletrotech.dominio.endereco.projection.EnderecoProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IEnderecoRepository extends JpaRepository<Endereco, UUID> {

    @Query(
            value = """
                    select
                    	e.id,
                    	e.nome_endereco nomeEndereco,
                    	e.rua,
                    	e.complemento,
                    	e.numero,
                    	e.bairro,
                    	e.cidade,
                    	e.estado siglaEstado,
                    	e.cep,
                    	e.created,
                     	e.updated,
                     	e.id_pessoa as pessoaId,
                    	p.nome  as pessoaNome,
                    	p.sobrenome as pessoaSobrenome,
                    	p.parentesco as pessoaParentesco,
                    	parent.id   as parentId,
                    	parent.nome as parentNome,
                    	parent.sobrenome as parentSobrenome,
                    	parent.parentesco as parentParentesco
                    	
                    from
                    	endereco e
                    inner join pessoa p on
                    	p.id = e.id_pessoa
                    left join pessoa parent on
                    	parent.id = p.id_parent
                    where (cast(:#{#filtro?.bairro} as varchar ) is null or upper(trim(e.bairro)) like  CONCAT('%',upper(trim(:#{#filtro?.bairro})),'%') )
                    and   (cast(:#{#filtro?.idPessoa} as uuid)  is null or e.id_pessoa = :#{#filtro?.idPessoa})
                    and   (cast(:#{#filtro?.cidade} as varchar) is null or  upper(trim(e.cidade)) like  CONCAT('%',upper(trim(:#{#filtro?.cidade})),'%'))
                    and   (cast(:#{#filtro?.rua} as varchar) is null or upper(trim(e.rua)) like  CONCAT('%',upper(trim(:#{#filtro?.rua})),'%'))
                    and   (cast(:#{#filtro?.siglaEstado} as varchar) is null or upper(trim(e.estado))    = upper(trim(:#{#filtro?.siglaEstado})) )
                                        
                    order by parent.nome, p.nome, e.estado, e.cidade
                    """,
            nativeQuery = true
    )
    Page<EnderecoProjection> consultarEnderecoPaginado(
            ListarEnderecoRequest filtro,
            Pageable pageable
    );
}
