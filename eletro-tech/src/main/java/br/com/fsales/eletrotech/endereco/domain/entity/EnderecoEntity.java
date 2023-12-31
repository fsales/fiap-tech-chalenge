package br.com.fsales.eletrotech.endereco.domain.entity;

import br.com.fsales.eletrotech.eletrodomestico.domain.entity.EletrodomesticoEntity;
import br.com.fsales.eletrotech.endereco.domain.enumeration.EstadoEnum;
import br.com.fsales.eletrotech.infrastructure.entitie.BaseEntity;
import br.com.fsales.eletrotech.pessoa.domain.entity.PessoaEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
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

public class EnderecoEntity extends BaseEntity {


    @EmbeddedId
    private EnderecoId enderecoId;

    @Column(name = "NOME_ENDERECO", nullable = false, length = 255)
    private String nomeEndereco;

    @Column(name = "CEP", nullable = false, length = 8)
    private String cep;

    @Column(name = "RUA", nullable = false, length = 100)
    private String rua;

    @Column(name = "COMPLEMENTO", nullable = false, length = 100)
    private String complemento;

    @Column(name = "NUMERO", nullable = false)
    private Integer numero;

    @Column(name = "BAIRRO", nullable = false, length = 100)
    private String bairro;

    @Column(name = "CIDADE", nullable = false, length = 100)
    private String cidade;

    @Column(name = "ESTADO", nullable = false, length = 2)
    private EstadoEnum estado;

    @MapsId(
            "idPessoa"
    )
    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "id_pessoa",
            referencedColumnName = "id",
            nullable = false
    )
    private PessoaEntity pessoa;

    @OneToMany(
            mappedBy = "endereco",
            cascade = CascadeType.REMOVE
    )
    private Set<EletrodomesticoEntity> eletrodomesticos = new LinkedHashSet<>();


    public EnderecoId getEnderecoId() {
        return enderecoId;
    }

    public EnderecoEntity setEnderecoId(EnderecoId enderecoId) {
        this.enderecoId = enderecoId;
        return this;
    }

    public String getNomeEndereco() {
        return nomeEndereco;
    }

    public EnderecoEntity setNomeEndereco(String nomeEndereco) {
        this.nomeEndereco = nomeEndereco;
        return this;
    }

    public String getCep() {
        return cep;
    }

    public EnderecoEntity setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public String getRua() {
        return rua;
    }

    public EnderecoEntity setRua(String rua) {
        this.rua = rua;
        return this;
    }

    public String getComplemento() {
        return complemento;
    }

    public EnderecoEntity setComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    public Integer getNumero() {
        return numero;
    }

    public EnderecoEntity setNumero(Integer numero) {
        this.numero = numero;
        return this;
    }

    public String getBairro() {
        return bairro;
    }

    public EnderecoEntity setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public String getCidade() {
        return cidade;
    }

    public EnderecoEntity setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public EstadoEnum getEstado() {
        return estado;
    }

    public EnderecoEntity setEstado(EstadoEnum estado) {
        this.estado = estado;
        return this;
    }

    public PessoaEntity getPessoa() {
        return pessoa;
    }

    public EnderecoEntity setPessoa(PessoaEntity pessoa) {
        this.pessoa = pessoa;
        return this;
    }

    public Set<EletrodomesticoEntity> getEletrodomesticos() {
        return eletrodomesticos;
    }

    public UUID getId() {
        return Objects.nonNull(enderecoId) ? enderecoId.getId() : null;
    }

    public UUID getIdPessoa() {
        return Objects.nonNull(enderecoId) ? enderecoId.getIdPessoa() : null;
    }

    /**
     * retorna o nome do estado com base no {@link EstadoEnum}
     *
     * @return
     */
    public String getNomeEstado() {
        return Objects.nonNull(estado) ? estado.nome() : null;
    }

    /**
     * retorna a sigla do estado com base no {@link EstadoEnum}
     *
     * @return
     */
    public String getSiglaEstado() {
        return Objects.nonNull(estado) ? estado.sigla() : null;
    }

}
