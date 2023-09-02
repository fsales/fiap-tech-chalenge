package br.com.fsales.eletrotech.eletrodomestico.domain.entity;

import br.com.fsales.eletrotech.dominio.endereco.entitie.Endereco;
import br.com.fsales.eletrotech.dominio.pessoa.entitie.Pessoa;
import br.com.fsales.eletrotech.infrastructure.entitie.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.UuidGenerator;

import java.util.Objects;
import java.util.UUID;

@Table
@Entity(name = "ELETRODOMESTICO")

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
public class EletrodomesticoEntity extends BaseEntity {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "ID", nullable = false)
    private UUID id;

    @Column(name = "NOME", nullable = false, length = 255)
    private String nome;

    @Column(name = "MODELO", nullable = false, length = 255)
    private String modelo;

    @Column(name = "POTENCIA", nullable = false)
    private Integer potencia;

    @Column(name = "FABRICANTE", nullable = false, length = 255)
    private String fabricante;

    @Column(name = "VOLTAGEM", nullable = false)
    private Integer voltagem;

    @Column(name = "TEMPO_USO_DIARIO", nullable = false)
    private Integer tempoUsoDiario;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumns({
            @JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa", nullable = false),
            @JoinColumn(name = "id_endereco", referencedColumnName = "id", nullable = false)
    })
    private Endereco endereco;

    public UUID getId() {
        return id;
    }

    public EletrodomesticoEntity setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public EletrodomesticoEntity setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getModelo() {
        return modelo;
    }

    public EletrodomesticoEntity setModelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public Integer getPotencia() {
        return potencia;
    }

    public EletrodomesticoEntity setPotencia(Integer potencia) {
        this.potencia = potencia;
        return this;
    }

    public String getFabricante() {
        return fabricante;
    }

    public EletrodomesticoEntity setFabricante(String fabricante) {
        this.fabricante = fabricante;
        return this;
    }

    public Integer getVoltagem() {
        return voltagem;
    }

    public EletrodomesticoEntity setVoltagem(Integer voltagem) {
        this.voltagem = voltagem;
        return this;
    }

    public Integer getTempoUsoDiario() {
        return tempoUsoDiario;
    }

    public EletrodomesticoEntity setTempoUsoDiario(Integer tempoUsoDiario) {
        this.tempoUsoDiario = tempoUsoDiario;
        return this;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public EletrodomesticoEntity setEndereco(Endereco endereco) {
        this.endereco = endereco;
        return this;
    }

    public Pessoa getPessoa() {
        return Objects.nonNull(this.endereco) &&
               Objects.nonNull(this.endereco.getEnderecoId()) ? this.endereco.getPessoa() : null;
    }

}
