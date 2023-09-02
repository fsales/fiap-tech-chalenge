package br.com.fsales.eletrotech.endereco.domain.projection;

import br.com.fsales.eletrotech.endereco.domain.enumeration.EstadoEnum;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public interface EnderecoProjection extends Serializable {

    UUID getId();

    String getNomeEndereco();

    String getRua();

    String getComplemento();

    Integer getNumero();

    String getBairro();

    String getCidade();

    String getSiglaEstado();

    String getCep();

    /**
     * retorna o nome do estado com base no {@link EstadoEnum}
     *
     * @return
     */
    default String getNomeEstado() {
        var estadoEnum = EstadoEnum.getEnum(getSiglaEstado());
        return Objects.nonNull(estadoEnum) ? estadoEnum.nome() : null;
    }

    Instant getCreated();

    Instant getUpdated();

    @Value(
            "#{new br.com.fsales.eletrotech.endereco.domain.projection.EnderecoProjection.PessoaProjection(target.pessoaId, target.pessoaNome, target.pessoaSobrenome,target.pessoaParentesco, new br.com.fsales.eletrotech.endereco.domain.projection.EnderecoProjection.ParentProjection(target.parentId, target.parentNome, target.parentSobrenome, target.parentParentesco))}")
    PessoaProjection getPessoa();

    /******************/
    record PessoaProjection(
            UUID idPessoa,
            String nome,
            String sobrenome,
            String parentesco,
            ParentProjection parent
    ) {

        /**
         * retorna o tipo da pessoa conforme a hierarquia
         *
         * @return
         */
        public String getTipoPessoa() {
            return Objects.isNull(parent)
                   || Objects.isNull(parent.idPessoa()) ? "Titular" : "Dependente";
        }
    }

    record ParentProjection(
            UUID idPessoa,
            String nome,
            String sobrenome,
            String parentesco
    ) {

    }
}
