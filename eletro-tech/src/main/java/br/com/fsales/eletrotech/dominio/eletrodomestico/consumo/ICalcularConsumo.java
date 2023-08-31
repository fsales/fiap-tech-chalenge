package br.com.fsales.eletrotech.dominio.eletrodomestico.consumo;

import java.util.Objects;

public interface ICalcularConsumo {


    default ConsumoResposta consumoAparelho(IDadosAparelho dadosAparelho) {
        if (
                Objects.isNull(dadosAparelho) ||
                        Objects.isNull(dadosAparelho.potencia()) ||
                        Objects.isNull(dadosAparelho.tempoUsoDiario())

        )
            return null;

        var wattHoras = dadosAparelho.potencia() *
                dadosAparelho.tempoUsoDiario();
        var wattNumeroDias = wattHoras * dadosAparelho.numeroDeDias();

        var watt = wattNumeroDias / 1_000;

        return new ConsumoResposta(watt, "kwh/Mês");
    }

    record ConsumoResposta(
            Integer watt,
            String unidadeMedida
    ) {

    }
}
