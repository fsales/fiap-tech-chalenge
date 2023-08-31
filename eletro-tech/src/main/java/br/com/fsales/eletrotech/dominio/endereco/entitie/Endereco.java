package br.com.fsales.eletrotech.dominio.endereco.entitie;

import br.com.fsales.eletrotech.dominio.endereco.enumeration.EstadoEnum;
import br.com.fsales.eletrotech.infrastructure.entitie.BaseEntity;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;
import java.util.UUID;

@Table
@Entity(name = "ENDERECO")

@EqualsAndHashCode(
        of = {"enderecoId"},
        callSuper = true
)
@ToString(
        of = {"enderecoId"},
        callSuper = true
)
@NoArgsConstructor
@AllArgsConstructor

public class Endereco extends BaseEntity {


    @EmbeddedId
    private EnderecoId enderecoId;

    private String nomeEndereco;

    private String cep;

    private String rua;

    private String complemento;

    private Integer numero;

    private String bairro;

    private String cidade;

    private EstadoEnum estado;

    public EnderecoId getEnderecoId() {
        return enderecoId;
    }

    public Endereco setEnderecoId(EnderecoId enderecoId) {
        this.enderecoId = enderecoId;
        return this;
    }

    public String getNomeEndereco() {
        return nomeEndereco;
    }

    public Endereco setNomeEndereco(String nomeEndereco) {
        this.nomeEndereco = nomeEndereco;
        return this;
    }

    public String getCep() {
        return cep;
    }

    public Endereco setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public String getRua() {
        return rua;
    }

    public Endereco setRua(String rua) {
        this.rua = rua;
        return this;
    }

    public String getComplemento() {
        return complemento;
    }

    public Endereco setComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    public Integer getNumero() {
        return numero;
    }

    public Endereco setNumero(Integer numero) {
        this.numero = numero;
        return this;
    }

    public String getBairro() {
        return bairro;
    }

    public Endereco setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public String getCidade() {
        return cidade;
    }

    public Endereco setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public EstadoEnum getEstado() {
        return estado;
    }

    public Endereco setEstado(EstadoEnum estado) {
        this.estado = estado;
        return this;
    }

    public UUID getId() {
        return Objects.nonNull(enderecoId) ? enderecoId.getId() : null;
    }

    public UUID getIdPessoa() {
        return Objects.nonNull(enderecoId) && Objects.nonNull(enderecoId.getPessoa()) ? enderecoId.getPessoa().getId() : null;
    }
}
