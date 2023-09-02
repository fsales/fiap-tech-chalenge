package br.com.fsales.eletrotech.eletrodomestico.aplication.dto;

public record FiltroListarEletrodomestico(
        String nome,
        String modelo,

        String fabricante,

        Integer potencia
) {
}
