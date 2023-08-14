package br.com.fsales.eletrotech.endereco.domain.enumeration.converter;

import br.com.fsales.eletrotech.endereco.domain.enumeration.EstadoEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class EstadoConverter implements AttributeConverter<EstadoEnum, String> {
    @Override
    public String convertToDatabaseColumn(EstadoEnum estado) {
        if (estado == null) {
            return null;
        }
        return estado.sigla();

    }

    @Override
    public EstadoEnum convertToEntityAttribute(String sigla) {
        if (sigla == null) {
            return null;
        }

        return Stream.of(EstadoEnum.values())
                .filter(s -> s.sigla().equalsIgnoreCase(sigla))
                .findFirst()
                .orElseThrow(
                        IllegalArgumentException::new
                );

    }
}
