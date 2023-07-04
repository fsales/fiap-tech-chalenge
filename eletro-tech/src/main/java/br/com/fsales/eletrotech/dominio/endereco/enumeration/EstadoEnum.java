package br.com.fsales.eletrotech.dominio.endereco.enumeration;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum EstadoEnum {

    AMAZONAS("Amazonas", "AM", "Manaus"),
    ALAGOAS("Alagoas", "AL", "Maceió"),
    ACRE("Acre", "AC", "Rio Branco"),
    AMAPA("Amapá", "AP", "Macapá"),
    BAHIA("Bahia", "BA", "Salvador"),
    PARA("Pará", "PA", "Belém"),
    MATO_GROSSO("Mato Grosso", "MT", "Cuiabá"),
    MINAS_GERAIS("Minas Gerais", "MG", "Belo Horizonte"),
    MATO_GROSSO_DO_SUL("Mato Grosso do Sul", "MS", "Campo Grande"),
    GOIAS("Goiás", "GO", "Goiânia"),
    MARANHAO("Maranhão", "MA", "São Luís"),
    RIO_GRANDE_DO_SUL("Rio Grande do Sul", "RS", "Porto Alegre"),
    TOCANTINS("Tocantins", "TO", "Palmas"),
    PIAUI("Piauí", "PI", "Teresina"),
    SAO_PAULO("São Paulo", "SP", "São Paulo"),
    RONDONIA("Rondônia", "RO", "Porto Velho"),
    RORAIMA("Roraima", "RR", "Boa Vista"),
    PARANA("Paraná", "PR", "Curitiba"),
    CEARA("Ceará", "CE", "Fortaleza"),
    PERNAMBUCO("Pernambuco", "PE", "Recife"),
    SANTA_CATARINA("Santa Catarina", "SC", "Florianópolis"),
    PARAIBA("Paraíba", "PB", "João Pessoa"),
    RIO_GRANDE_DO_NORTE("Rio Grande do Norte", "RN", "Natal"),
    ESPIRITO_SANTO("Espírito Santo", "ES", "Vitória"),
    RIO_DE_JANEIRO("Rio de Janeiro", "RJ", "Rio de Janeiro"),
    SERGIPE("Sergipe", "SE", "Aracaju"),
    DISTRITO_FEDERAL("Distrito Federal", "DF", "Brasília");


    private static final Map<String, EstadoEnum> SIGLA_ESTADO_MAP =
            Arrays.stream(
                            EstadoEnum.values()
                    )
                    .collect(
                            Collectors.toMap(e -> e.sigla, e -> e)
                    );

    private final String nome;
    private final String sigla;
    private final String capital;

    /**
     * @param nome    nome da unidade da federação completo
     * @param sigla   sigla da unidade da federação
     * @param capital nome da capital da unidade da federação
     */
    EstadoEnum(final String nome, final String sigla, final String capital) {
        this.nome = nome;
        this.sigla = sigla;
        this.capital = capital;
    }

    public String nome() {
        return nome;
    }

    public String sigla() {
        return sigla;
    }

    public String capital() {
        return capital;
    }

    /**
     * @param sigla
     * @return
     */
    public static EstadoEnum getEnum(String sigla) {
        var s = sigla == null ? null : sigla.toUpperCase();

        if (!SIGLA_ESTADO_MAP.containsKey(s)) return null;

        return SIGLA_ESTADO_MAP.get(s);
    }
}
