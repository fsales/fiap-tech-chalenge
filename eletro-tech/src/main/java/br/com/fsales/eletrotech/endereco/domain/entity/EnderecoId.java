package br.com.fsales.eletrotech.endereco.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.UUID;

@EqualsAndHashCode
@ToString

@Embeddable
public class EnderecoId implements Serializable {

    private static final long serialVersionUID = -625014989758525368L;

    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "id_pessoa", nullable = false)
    private UUID idPessoa;

    public EnderecoId() {
    }

    public EnderecoId(
            UUID id,
            UUID idPessoa
    ) {
        this.id = id;
        this.idPessoa = idPessoa;
    }

    public UUID getId() {
        return id;
    }

    public EnderecoId setId(UUID id) {
        this.id = id;
        return this;
    }

    public UUID getIdPessoa() {
        return idPessoa;
    }

    public EnderecoId setIdPessoa(UUID idPessoa) {
        this.idPessoa = idPessoa;
        return this;
    }
}
