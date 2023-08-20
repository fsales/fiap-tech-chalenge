package br.com.fsales.eletrotech.dominio.endereco.repository;

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
                    	e.rua,
                    	e.complemento,
                    	e.numero,
                    	e.bairro,
                    	e.cidade,
                    	e.estado siglaEstado,
                    	e.cep,
                    	e.id_pessoa idPessoa,
                    	e.created,
                     	e.updated,
                    	p.nome,
                    	p.sobreNome,
                    	parent.nome nomeTitular
                    from
                    	endereco e
                    inner join pessoa p on
                    	p.id = e.id_pessoa
                    left join pessoa parent on
                    	parent.id = p.id_parent
                    order by parent.nome, p.nome
                    """,
            nativeQuery = true
    )
    Page<EnderecoProjection> consultarEnderecoPaginado(Pageable pageable);
}
