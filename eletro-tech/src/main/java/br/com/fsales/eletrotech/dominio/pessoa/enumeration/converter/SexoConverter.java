package br.com.fsales.eletrotech.dominio.pessoa.enumeration.converter;

import br.com.fsales.eletrotech.dominio.pessoa.enumeration.SexoEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)

public class SexoConverter implements AttributeConverter<SexoEnum, String> {
    @Override
    public String convertToDatabaseColumn(SexoEnum sexo) {
        if (sexo == null) {
            return null;
        }
        return sexo.getSigla();

    }

    @Override
    public SexoEnum convertToEntityAttribute(String sigla) {
        if (sigla == null) {
            return null;
        }

        return Stream.of(SexoEnum.values())
                .filter(s -> s.getSigla().equalsIgnoreCase(sigla))
                .findFirst()
                .orElseThrow(
                        IllegalArgumentException::new
                );

    }
}
