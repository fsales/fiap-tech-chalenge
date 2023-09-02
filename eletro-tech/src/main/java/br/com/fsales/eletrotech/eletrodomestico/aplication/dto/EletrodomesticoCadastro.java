package br.com.fsales.eletrotech.eletrodomestico.aplication.dto;

import br.com.fsales.eletrotech.eletrodomestico.aplication.validacao.IEletrodomestico;

import java.io.Serializable;
import java.util.UUID;

public record EletrodomesticoCadastro(
        UUID idPessoa,
        UUID idEndereco,
        String nome,
        String modelo,
        Integer potencia,
        String fabricante,
        Integer voltagem,
        Integer tempoUsoDiario
) implements IEletrodomestico, Serializable {
}
