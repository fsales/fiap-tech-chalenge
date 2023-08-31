package br.com.fsales.eletrotech.dominio.eletrodomestico.projection;

import java.util.UUID;

public record Parent(
        UUID id,
        String nome,
        String sobrenome
) {
}
