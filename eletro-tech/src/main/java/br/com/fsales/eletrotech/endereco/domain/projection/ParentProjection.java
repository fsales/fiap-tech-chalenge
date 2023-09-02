package br.com.fsales.eletrotech.endereco.domain.projection;


import java.util.UUID;

public record ParentProjection(
        UUID idPessoa,
        String nome,
        String sobrenome,
        String parentesco
) {

}
