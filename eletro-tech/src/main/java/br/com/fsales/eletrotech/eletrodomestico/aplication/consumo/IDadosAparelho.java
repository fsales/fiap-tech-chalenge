package br.com.fsales.eletrotech.eletrodomestico.aplication.consumo;

public interface IDadosAparelho {

    /**
     * Potência do aparelho em Watts
     *
     * @return
     */
    Integer potencia();

    /**
     * Horas por dia de utilização do aparelho
     *
     * @return
     */
    Integer tempoUsoDiario();

    /**
     * Número de dias de utilização do aparelho
     * Por padrão será considerado 30 dias
     *
     * @return
     */
    default int numeroDeDias() {
        return 30;
    }

}
