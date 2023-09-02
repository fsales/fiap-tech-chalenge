package br.com.fsales.eletrotech.eletrodomestico.aplication.dto;

import br.com.fsales.eletrotech.eletrodomestico.aplication.validacao.IEletrodomestico;

import java.util.UUID;

public record EletrodomesticoAtualizar(
        UUID id,
        UUID idPessoa,
        UUID idEndereco,
        String nome,
        String modelo,
        Integer potencia,
        String fabricante,
        Integer voltagem,
        Integer tempoUsoDiario
) implements IEletrodomestico {
}
