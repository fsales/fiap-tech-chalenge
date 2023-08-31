package br.com.fsales.eletrotech.dominio.endereco.entitie;

import br.com.fsales.eletrotech.dominio.pessoa.entitie.Pessoa;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.UUID;

@EqualsAndHashCode

@Embeddable
public class EnderecoId implements Serializable {

    private UUID id;

    @ManyToOne
    @JoinColumn(
            name = "id_pessoa",
            referencedColumnName = "id"
    )
    private Pessoa pessoa;

    public EnderecoId() {
    }

    public EnderecoId(
            UUID id,
            UUID idPessoa
    ) {
        this.id = id;
        this.pessoa = Pessoa
                .builder()
                .id(idPessoa)
                .build();
    }

    public UUID id() {
        return id;
    }

    public EnderecoId setId(UUID id) {
        this.id = id;
        return this;
    }

    public Pessoa pessoa() {
        return pessoa;
    }

    public EnderecoId setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
        return this;
    }
}
