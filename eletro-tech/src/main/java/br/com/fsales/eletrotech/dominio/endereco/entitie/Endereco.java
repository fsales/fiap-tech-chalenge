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

    public EnderecoId enderecoId() {
        return enderecoId;
    }

    public Endereco setEnderecoId(EnderecoId enderecoId) {
        this.enderecoId = enderecoId;
        return this;
    }

    public String nomeEndereco() {
        return nomeEndereco;
    }

    public Endereco setNomeEndereco(String nomeEndereco) {
        this.nomeEndereco = nomeEndereco;
        return this;
    }

    public String cep() {
        return cep;
    }

    public Endereco setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public String rua() {
        return rua;
    }

    public Endereco setRua(String rua) {
        this.rua = rua;
        return this;
    }

    public String complemento() {
        return complemento;
    }

    public Endereco setComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    public Integer numero() {
        return numero;
    }

    public Endereco setNumero(Integer numero) {
        this.numero = numero;
        return this;
    }

    public String bairro() {
        return bairro;
    }

    public Endereco setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public String cidade() {
        return cidade;
    }

    public Endereco setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public EstadoEnum estado() {
        return estado;
    }

    public Endereco setEstado(EstadoEnum estado) {
        this.estado = estado;
        return this;
    }

    public UUID id() {
        return Objects.nonNull(enderecoId) ? enderecoId.id() : null;
    }

    public UUID idPessoa() {
        return Objects.nonNull(enderecoId) && Objects.nonNull(enderecoId.pessoa()) ? enderecoId.pessoa().id() : null;
    }
}
