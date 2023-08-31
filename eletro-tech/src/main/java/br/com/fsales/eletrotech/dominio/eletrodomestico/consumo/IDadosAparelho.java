package br.com.fsales.eletrotech.dominio.eletrodomestico.consumo;

public interface IDadosAparelho {

    /**
     * Potência do aparelho em Watts
     *
     * @return
     */
    default Integer potencia() {
        return 0;
    }

    /**
     * Horas por dia de utilização do aparelho
     *
     * @return
     */
    default Integer tempoUsoDiario() {
        return 0;
    }

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
