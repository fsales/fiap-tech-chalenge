package br.com.fsales.eletrotech.endereco.domain.projection;

import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;
import java.time.Instant;
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

    Instant getCreated();

    Instant getUpdated();

    @Value(
            "#{new br.com.fsales.eletrotech.endereco.domain.projection.PessoaProjection(target.pessoaId, target.pessoaNome, target.pessoaSobrenome,target.pessoaParentesco, new br.com.fsales.eletrotech.endereco.domain.projection.ParentProjection(target.parentId, target.parentNome, target.parentSobrenome, target.parentParentesco))}")
    PessoaProjection getPessoa();
}
