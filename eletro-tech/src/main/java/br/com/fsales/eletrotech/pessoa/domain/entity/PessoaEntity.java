package br.com.fsales.eletrotech.pessoa.domain.entity;

import br.com.fsales.eletrotech.endereco.domain.entity.EnderecoEntity;
import br.com.fsales.eletrotech.infrastructure.entitie.BaseEntity;
import br.com.fsales.eletrotech.pessoa.domain.enumeration.ParentescoEnum;
import br.com.fsales.eletrotech.pessoa.domain.enumeration.SexoEnum;
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
public final class PessoaEntity extends BaseEntity {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @NotEmpty
    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    @NotEmpty
    @Column(name = "SOBRENOME", nullable = false, length = 100)
    private String sobrenome;

    @Past
    @Column(name = "DATA_NASCIMENTO", nullable = false)
    private LocalDate dataNascimento;

    @CPF
    @Column(name = "CPF", nullable = false, length = 11)
    private String cpf;

    @NotNull
    @Column(name = "SEXO", nullable = false, length = 1)
    private SexoEnum sexo;

    @Column(name = "PARENTESCO", nullable = false, length = 1)
    private ParentescoEnum parentesco;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "id_parent",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_PARENT_PESSOA")
    )
    private PessoaEntity parent;

    @OneToMany(mappedBy = "parent")
    private Set<PessoaEntity> dependentes = new LinkedHashSet<>();


    @OneToMany(
            mappedBy = "pessoa"
    )
    private Set<EnderecoEntity> enderecos = new LinkedHashSet<>();


    public UUID getId() {
        return id;
    }

    public PessoaEntity setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public PessoaEntity setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public PessoaEntity setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
        return this;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public PessoaEntity setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public PessoaEntity setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public SexoEnum getSexo() {
        return sexo;
    }

    public PessoaEntity setSexo(SexoEnum sexo) {
        this.sexo = sexo;
        return this;
    }

    public ParentescoEnum getParentesco() {
        return parentesco;
    }

    public PessoaEntity setParentesco(ParentescoEnum parentesco) {
        this.parentesco = parentesco;
        return this;
    }

    public PessoaEntity getParent() {
        return parent;
    }

    public PessoaEntity setParent(PessoaEntity parent) {
        this.parent = parent;
        return this;
    }

    public Set<PessoaEntity> getDependentes() {
        return dependentes;
    }

    public PessoaEntity setDependentes(Set<PessoaEntity> dependentes) {
        this.dependentes = dependentes;
        return this;
    }

    public Set<EnderecoEntity> getEnderecos() {
        return enderecos;
    }

    public PessoaEntity setEnderecos(Set<EnderecoEntity> enderecos) {
        this.enderecos = enderecos;
        return this;
    }

    public PessoaEntity addDependentes(List<PessoaEntity> dependentes) {
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

    /**
     * retorna a sexo da pessoa com base no {@link SexoEnum}
     *
     * @return
     */
    public String getSexoDescricao() {
        return sexo == null ? null : sexo.getDescricao();
    }
}
