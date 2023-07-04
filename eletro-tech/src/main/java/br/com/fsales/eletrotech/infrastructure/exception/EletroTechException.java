package br.com.fsales.eletrotech.infrastructure.exception;

public class EletroTechException extends RuntimeException {
    private final String propertieName;

    public EletroTechException(String message, Throwable cause) {
        super(message, cause);
        this.propertieName = null;
    }


    public EletroTechException(String message) {
        super(message);
        this.propertieName = null;
    }


    public EletroTechException(String propertieName, String message, Throwable cause) {
        super(message, cause);
        this.propertieName = propertieName;
    }

    /**
     * Recupera o nome da propriedade informada na exceção.
     *
     * @return nome da propriedade definida no módulo i18n.
     */
    public String getPropertieName() {
        return propertieName;
    }
}
