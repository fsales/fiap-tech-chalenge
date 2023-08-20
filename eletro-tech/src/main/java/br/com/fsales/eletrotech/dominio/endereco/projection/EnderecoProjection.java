package br.com.fsales.eletrotech.dominio.endereco.projection;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

public interface EnderecoProjection extends Serializable {

    UUID getId();

    String getRua();

    String getComplemento();

    Integer getNumero();

    String getBairro();

    String getCidade();

    String getSiglaEstado();

    String getCep();

    Instant getCreated();

    Instant getUpdated();

    UUID getIdPessoa();

    String getNome();

    String getSobreNome();

    String getNomeTitular();
}
