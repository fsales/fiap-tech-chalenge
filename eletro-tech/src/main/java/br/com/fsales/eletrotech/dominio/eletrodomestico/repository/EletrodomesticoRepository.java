package br.com.fsales.eletrotech.dominio.eletrodomestico.repository;

import br.com.fsales.eletrotech.dominio.eletrodomestico.entitie.Eletrodomestico;
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
                    el.id elId,
                    el.nome elNome,
                    el.modelo elModelo,
                    el.fabricante elFabricante,
                    el.potencia elPotencia,
                    el.voltagem elVoltagem,
                    el.tempo_uso_diario elTempoUsoDiario,
                    el.id_pessoa elIdPessoa,
                    el.id_endereco elIdEndereco,
                    p.id pId,
                    p.id_parent pIdParent,
                    p.nome pNome,
                    p.sobrenome pSobrenome,
                    p.cpf pCpf,
                    p.data_nascimento pDataNascimento,
                    p.sexo pSexo,
                    p.parentesco pParentesco,
                    e.id,
                    e.id_pessoa idPesssoa,
                    e.nome_endereco nomeEndereco,
                    e.cep,
                    e.rua,
                    e.complemento,
                    e.numero,
                    e.bairro,
                    e.cidade,
                    e.estado
                from
                    eletrodomestico el
                inner join endereco e on
                    (e.id_pessoa = el.id_pessoa
                        and e.id = el.id_endereco)
                inner join pessoa p on
                    p.id = el.id_pessoa
            """,
            nativeQuery = true)
    Page<?> consultarEnderecoPaginado(
            Pageable pageable
    );
}
