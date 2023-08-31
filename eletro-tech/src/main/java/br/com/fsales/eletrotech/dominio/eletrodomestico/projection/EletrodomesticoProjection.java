package br.com.fsales.eletrotech.dominio.eletrodomestico.projection;

import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;
import java.util.UUID;

public interface EletrodomesticoProjection extends Serializable {

    UUID getId();

    String getNome();

    String getModelo();

    String getFabricante();

    String getPotencia();

    String getVoltagem();

    String getTempoUsoDiario();

    @Value("#{new br.com.fsales.eletrotech.dominio.eletrodomestico.projection.PessoaProjection(target.pId, target.pNome, target.pSobrenome, target.pParentesco, new br.com.fsales.eletrotech.dominio.eletrodomestico.projection.Parent(target.parentId, target.parentNome, target.parentSobrenome))}")
    PessoaProjection getPessoa();

    @Value("#{new br.com.fsales.eletrotech.dominio.eletrodomestico.projection.EnderecoProjection(target.eId, target.eCep, target.eRua, target.eComplemento, target.eNumero, target.eBairro, target.eCidade, target.eEstado, target.eNomeEndereco)}")
    EnderecoProjection getEndereco();

}
