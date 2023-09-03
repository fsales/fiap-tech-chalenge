package br.com.fsales.eletrotech.pessoa.domain.enumeration;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum SexoEnum {
    MASCULINO {
        @Override
        public String getSigla() {
            return "M";
        }

        @Override
        public String getDescricao() {
            return "Masculino";
        }
    }, FEMININO {
        @Override
        public String getSigla() {
            return "F";
        }

        @Override
        public String getDescricao() {
            return "Feminino";
        }
    }, OUTRO {
        @Override
        public String getSigla() {
            return "O";
        }

        @Override
        public String getDescricao() {
            return "Outros";
        }
    };


    private static final Map<String, SexoEnum> SIGLA_SEXO_MAP =
            Arrays.stream(
                            SexoEnum.values()
                    )
                    .collect(
                            Collectors.toMap(SexoEnum::getSigla, e -> e)
                    );

    /**
     * @return
     */
    public abstract String getSigla();

    /**
     * @return
     */
    public abstract String getDescricao();

    public static SexoEnum getEnum(String siglaSexo) {
        var sigla = siglaSexo == null ? null : siglaSexo.toUpperCase();

        if (sigla == null
            || !SIGLA_SEXO_MAP.containsKey(sigla)) return null;

        return SIGLA_SEXO_MAP.get(sigla);
    }
}
