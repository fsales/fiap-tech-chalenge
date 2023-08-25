package br.com.fsales.eletrotech.infrastructure.exception;

import br.com.fsales.eletrotech.infrastructure.exception.dto.Violation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EletroTechNegocioException extends RuntimeException {

    /**
     * -- GETTER --
     *
     * @return
     */
    private final List<Violation> list = new ArrayList<>();

    public EletroTechNegocioException() {
        super();
    }

    public EletroTechNegocioException(String message) {
        addMensagem(message);
    }

    /**
     * Adiciona na lista de mensagens
     *
     * @param fieldName
     * @param mensagem
     */
    public void addMensagem(
            String fieldName,
            String mensagem) {
        this.list.add(
                Violation
                        .builder()
                        .fieldName(fieldName)
                        .message(mensagem)
                        .build()
        );
    }

    /**
     * Adiciona na lista de mensagens
     *
     * @param mensagem
     */
    public void addMensagem(
            String mensagem
    ) {
        this.list.add(
                Violation
                        .builder()
                        .message(mensagem)
                        .build()
        );
    }

    /**
     * @return
     */
    public List<Violation> list() {
        return Collections.unmodifiableList(this.list);
    }

    /**
     *
     */
    public void limparList() {
        this.list.clear();
    }

    /**
     * @return
     */
    public boolean lancarErro() {
        return !list.isEmpty();
    }
}
