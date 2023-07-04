package br.com.fsales.eletrotech.infrastructure.handler;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageHandler {
    private final MessageSource messageSource;

    public MessageHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * Obetem mensagem do arquivo de propriedades por localidade geográfica
     *
     * @param message texto ou propriedade definida no i18n
     * @param locale  geográfica {@link Locale}
     * @param args    argumentos {@link Object}
     * @return texto da mensagem
     */
    public String getMessage(String message, Locale locale, Object... args) {
        return messageSource.getMessage(message, args, locale);
    }

    /**
     * Obetem mensagem do arquivo de propriedades por localidade geográfica padrão
     *
     * @param message texto ou propriedade definida no i18n
     * @param args    argumentos {@link Object}
     * @return texto da mensagem
     */
    public String getMessage(String message, Object... args) {
        return messageSource.getMessage(message, args, Locale.getDefault());
    }
}
