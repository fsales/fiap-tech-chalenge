package br.com.fsales.eletrotech.pessoa.application.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public record PessoaDTO(
        UUID id,
        String nome,
        String sobrenome,
        LocalDate dataNascimento,
        String cpf,
        PessoaDTO parent,
        Instant created,
        Instant updated,
        List<PessoaDTO> dependentes,
        Set<EnderecoDTO> enderecos,
        String descricaoParentesco,
        String siglaParentesco,
        String tipoPessoa,
        String sexoDescricao
) {


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", id)
                .append("nome", nome)
                .append("cpf", cpf)
                .toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PessoaDTO pessoa)) {
            return false;
        }
        return new EqualsBuilder().append(this.id, pessoa.id)
                .append(this.nome, pessoa.nome).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(nome).toHashCode();
    }

    /*****************/

    public record EnderecoDTO(
            UUID id,
            String nomeEndereco,
            String cep,

            String rua,

            String complemento,

            Integer numero,

            String bairro,

            String cidade,

            String nomeEstado,

            String siglaEstado
    ) {

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                    .append("id", id)
                    .append("nome", nomeEndereco)
                    .toString();
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof PessoaDTO.EnderecoDTO enderecoDTO)) {
                return false;
            }
            return new EqualsBuilder().append(this.id, enderecoDTO.id)
                    .append(this.nomeEndereco, enderecoDTO.nomeEndereco).isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder().append(id).append(nomeEndereco).toHashCode();
        }
    }
}
