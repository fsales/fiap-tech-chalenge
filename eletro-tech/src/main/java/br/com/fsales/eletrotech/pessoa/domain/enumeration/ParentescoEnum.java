package br.com.fsales.eletrotech.pessoa.domain.enumeration;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum ParentescoEnum {
    PAI {
        @Override
        public String getDescricao() {
            return "Pai";
        }

        @Override
        public String getSigla() {
            return "P";
        }
    }, MAE {
        @Override
        public String getDescricao() {
            return "Mãe";
        }

        @Override
        public String getSigla() {
            return "M";
        }
    }, IRMAO {
        @Override
        public String getDescricao() {
            return "Irmão(a)";
        }

        @Override
        public String getSigla() {
            return "I";
        }
    }, FILHO {
        @Override
        public String getDescricao() {
            return "Filho(a)";
        }

        @Override
        public String getSigla() {
            return "F";
        }
    }, OUTROS {
        @Override
        public String getDescricao() {
            return "Outros";
        }

        @Override
        public String getSigla() {
            return "O";
        }
    };

    private static final Map<String, ParentescoEnum> SIGLA_PARENTESCO_MAP =
            Arrays.stream(
                            ParentescoEnum.values()
                    )
                    .collect(
                            Collectors.toMap(ParentescoEnum::getSigla, e -> e)
                    );


    public abstract String getDescricao();

    public abstract String getSigla();

    public static ParentescoEnum getEnum(String siglaParentesco) {
        var sigla = siglaParentesco == null ? null : siglaParentesco.toUpperCase();


        if (sigla == null
            || !SIGLA_PARENTESCO_MAP.containsKey(sigla)) return null;

        return SIGLA_PARENTESCO_MAP.get(sigla);
    }
}
