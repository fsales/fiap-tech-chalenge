package br.com.fsales.eletrotech.eletrodomestico.aplication.dto;

public record FiltroListarEletrodomesticoDTO(
        String nome,
        String modelo,

        String fabricante,

        Integer potencia
) {
}
