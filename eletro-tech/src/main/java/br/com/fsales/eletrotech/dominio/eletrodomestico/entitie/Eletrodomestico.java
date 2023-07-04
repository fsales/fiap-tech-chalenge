package br.com.fsales.eletrotech.dominio.eletrodomestico.entitie;

import br.com.fsales.eletrotech.infrastructure.entitie.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.UuidGenerator;

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
public class Eletrodomestico extends BaseEntity {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    private String nome;

    private String modelo;

    private Integer potencia;

    private String fabricante;

    private Integer voltagem;

    private Integer tempoUsoDiario;

    public UUID id() {
        return id;
    }

    public UUID getId() {
        return id;
    }

    public Eletrodomestico setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Eletrodomestico setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getModelo() {
        return modelo;
    }

    public Eletrodomestico setModelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public Integer getPotencia() {
        return potencia;
    }

    public Eletrodomestico setPotencia(Integer potencia) {
        this.potencia = potencia;
        return this;
    }

    public String getFabricante() {
        return fabricante;
    }

    public Eletrodomestico setFabricante(String fabricante) {
        this.fabricante = fabricante;
        return this;
    }

    public Integer getVoltagem() {
        return voltagem;
    }

    public Eletrodomestico setVoltagem(Integer voltagem) {
        this.voltagem = voltagem;
        return this;
    }

    public Integer getTempoUsoDiario() {
        return tempoUsoDiario;
    }

    public Eletrodomestico setTempoUsoDiario(Integer tempoUsoDiario) {
        this.tempoUsoDiario = tempoUsoDiario;
        return this;
    }
}
