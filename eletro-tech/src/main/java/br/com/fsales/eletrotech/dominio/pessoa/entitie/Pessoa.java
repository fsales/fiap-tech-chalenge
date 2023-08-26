package br.com.fsales.eletrotech.dominio.pessoa.entitie;

import br.com.fsales.eletrotech.dominio.endereco.entitie.Endereco;
import br.com.fsales.eletrotech.dominio.pessoa.enumeration.ParentescoEnum;
import br.com.fsales.eletrotech.dominio.pessoa.enumeration.SexoEnum;
import br.com.fsales.eletrotech.infrastructure.entitie.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Table
@Entity(name = "PESSOA")

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

public final class Pessoa extends BaseEntity {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @NotEmpty
    private String nome;

    @NotEmpty
    private String sobrenome;

    @Past
    private LocalDate dataNascimento;

    @CPF
    private String cpf;

    @NotNull
    private SexoEnum sexo;

    private ParentescoEnum parentesco;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "id_parent",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_PARENT_PESSOA")
    )
    private Pessoa parent;

    @OneToMany(mappedBy = "parent")
    private List<Pessoa> dependentes = new ArrayList<>();


    @OneToMany(
            mappedBy = "pessoa"
    )
    private List<Endereco> enderecos = List.of();

    @Override
    public UUID getId() {
        return id;
    }

    public Pessoa setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Pessoa setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public Pessoa setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
        return this;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Pessoa setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public Pessoa setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public SexoEnum getSexo() {
        return sexo;
    }

    public Pessoa setSexo(SexoEnum sexo) {
        this.sexo = sexo;
        return this;
    }

    public ParentescoEnum getParentesco() {
        return parentesco;
    }

    public Pessoa setParentesco(ParentescoEnum parentesco) {
        this.parentesco = parentesco;
        return this;
    }

    public Pessoa getParent() {
        return parent;
    }

    public Pessoa setParent(Pessoa parent) {
        this.parent = parent;
        return this;
    }

    public List<Pessoa> getDependentes() {
        return dependentes;
    }

    public Pessoa setDependentes(List<Pessoa> dependentes) {
        this.dependentes = dependentes;
        return this;
    }

    public Pessoa addDependentes(List<Pessoa> dependentes) {
        if (Objects.nonNull(dependentes))
            this.dependentes.addAll(dependentes);
        return this;
    }


    public List<Endereco> enderecos() {
        return enderecos;
    }
}
