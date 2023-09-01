package br.com.fsales.eletrotech.dominio.pessoa.entitie;

import br.com.fsales.eletrotech.dominio.endereco.entitie.Endereco;
import br.com.fsales.eletrotech.dominio.pessoa.enumeration.ParentescoEnum;
import br.com.fsales.eletrotech.dominio.pessoa.enumeration.SexoEnum;
import br.com.fsales.eletrotech.infrastructure.entitie.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.*;

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
@Builder
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
    private Set<Pessoa> dependentes = new LinkedHashSet<>();


    @OneToMany(
            mappedBy = "pessoa"
    )
    private Set<Endereco> enderecos = new LinkedHashSet<>();


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

    public Set<Pessoa> getDependentes() {
        return dependentes;
    }

    public Pessoa setDependentes(Set<Pessoa> dependentes) {
        this.dependentes = dependentes;
        return this;
    }

    public Set<Endereco> getEnderecos() {
        return enderecos;
    }

    public Pessoa setEnderecos(Set<Endereco> enderecos) {
        this.enderecos = enderecos;
        return this;
    }

    public Pessoa addDependentes(List<Pessoa> dependentes) {
        if (Objects.nonNull(dependentes))
            this.dependentes.addAll(dependentes);
        return this;
    }

    /**
     * retorna a descrição do parentesco com base no {@link ParentescoEnum}
     *
     * @return
     */
    public String getDescricaoParentesco() {

        return parentesco == null ? null : parentesco.getDescricao();
    }

    /**
     * retorna a sigla do parentesco com base no {@link ParentescoEnum}
     *
     * @return
     */
    public String getSiglaParentesco() {

        return parentesco == null ? null : parentesco.getSigla();
    }

    /**
     * retorna o tipo da pessoa conforme a hierarquia
     *
     * @return
     */
    public String getTipoPessoa() {
        return Objects.isNull(parent)
               || Objects.isNull(parent.getId()) ? "Titular" : "Dependente";
    }
}
