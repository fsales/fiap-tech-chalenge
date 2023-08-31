package br.com.fsales.eletrotech.dominio.eletrodomestico.projection;

import java.util.UUID;

public record PessoaProjection(
        UUID id,
        String nome,
        String sobrenome,
        String parentesco,
        Parent parent
) {
}