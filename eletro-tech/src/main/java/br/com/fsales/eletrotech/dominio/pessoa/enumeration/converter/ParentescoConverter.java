package br.com.fsales.eletrotech.dominio.pessoa.enumeration.converter;

import br.com.fsales.eletrotech.dominio.pessoa.enumeration.ParentescoEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)

public class ParentescoConverter implements AttributeConverter<ParentescoEnum, String> {
    @Override
    public String convertToDatabaseColumn(ParentescoEnum parentesco) {
        if (parentesco == null) {
            return null;
        }
        return parentesco.getSigla();

    }

    @Override
    public ParentescoEnum convertToEntityAttribute(String sigla) {
        if (sigla == null) {
            return null;
        }

        return Stream.of(ParentescoEnum.values())
                .filter(p -> p.getSigla().equalsIgnoreCase(sigla))
                .findFirst()
                .orElseThrow(
                        IllegalArgumentException::new
                );

    }
}
