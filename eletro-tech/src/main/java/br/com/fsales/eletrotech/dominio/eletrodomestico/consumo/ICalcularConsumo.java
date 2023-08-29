package br.com.fsales.eletrotech.dominio.eletrodomestico.consumo;

import java.util.Objects;

public interface ICalcularConsumo {


    default ConsumoResposta consumoAparelho(IDadosAparelho dadosAparelho) {
        if (Objects.isNull(dadosAparelho))
            return null;

        var wattHoras = dadosAparelho.potencia() *
                        dadosAparelho.tempoUsoDiario();
        var wattNumeroDias = wattHoras * dadosAparelho.numeroDeDias();

        Double watt = (double) (wattNumeroDias / 1_000);

        return new ConsumoResposta(watt, "kwh/Mês");
    }

    record ConsumoResposta(
            Double watt,
            String unidadeMedida
    ) {

    }
}
