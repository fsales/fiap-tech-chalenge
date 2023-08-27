package br.com.fsales.eletrotech.dominio.endereco.entitie;

import br.com.fsales.eletrotech.dominio.endereco.enumeration.EstadoEnum;
import br.com.fsales.eletrotech.dominio.pessoa.entitie.Pessoa;
import br.com.fsales.eletrotech.infrastructure.entitie.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Table
@Entity(name = "ENDERECO")

@EqualsAndHashCode(
        of = {"id"},
        callSuper = true
)
@ToString(
        of = {"id"},
        callSuper = true
)
@NoArgsConstructor
@AllArgsConstructor

public class Endereco extends BaseEntity {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    private String nomeEndereco;

    private String cep;

    private String rua;

    private String complemento;

    private Integer numero;

    private String bairro;

    private String cidade;

    private EstadoEnum estado;

    @ManyToOne
    @JoinColumn(
            name = "id_pessoa",
            referencedColumnName = "id",
            columnDefinition = "FK_ENDERECO_PESSOA"
    )
    private Pessoa pessoa;

    @Override
    public UUID getId() {
        return id;
    }

    public Endereco setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getNomeEndereco() {
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

    public Endereco setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
        return this;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }


}
