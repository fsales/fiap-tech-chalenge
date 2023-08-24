package br.com.fsales.eletrotech.dominio.endereco.projection;


import java.util.UUID;

public record ParentProjection(
        UUID idPessoa,
        String nome,
        String sobrenome,
        String parentesco
) {

}
