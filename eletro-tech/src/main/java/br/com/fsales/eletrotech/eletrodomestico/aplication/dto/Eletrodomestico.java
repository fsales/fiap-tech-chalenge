package br.com.fsales.eletrotech.eletrodomestico.aplication.dto;

import br.com.fsales.eletrotech.eletrodomestico.aplication.consumo.ICalcularConsumo;
import br.com.fsales.eletrotech.eletrodomestico.aplication.consumo.IDadosAparelho;

import java.time.Instant;
import java.util.UUID;

public record Eletrodomestico(
        UUID id,
        UUID idPessoa,
        UUID idEndereco,
        String nome,
        String modelo,
        Integer potencia,
        String fabricante,
        Integer voltagem,
        Integer tempoUsoDiario,
        Instant created,
        Instant updated,
        Pessoa pessoa,
        Endereco endereco
) implements IDadosAparelho, ICalcularConsumo {


    /**
     * Calcular o consumo do eletrodomestico
     *
     * @return
     */
    public ConsumoResposta getConsumo() {
        return consumoAparelho(this);
    }


    /****************************/
    public record Endereco(

            UUID id,
            String nomeEndereco,
            String cep,
            String rua,
            String complemento,
            Integer numero,
            String bairro,
            String cidade,
            Instant created,
            Instant updated,
            String siglaEstado,
            String nomeEstado
    ) {

    }

    /****************************/
    public record Pessoa(

            UUID idPessoa,
            String nome,
            String sobrenome,
            Pessoa parent,
            String descricaoParentesco,
            String siglaParentesco,
            String tipoPessoa
    ) {
    }
}