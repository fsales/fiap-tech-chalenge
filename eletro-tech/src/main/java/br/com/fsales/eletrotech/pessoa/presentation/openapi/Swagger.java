package br.com.fsales.eletrotech.pessoa.presentation.openapi;

public final class Swagger {

    /**
     * Api de Pessoas
     */

    public static final String API_PESSOA_TAG_NAME = "API de gestão de pessoas";
    public static final String API_PESSOA_TAG_DESCRIPTION = "Tem como objetivo permitir o cadastro e gerenciamento de informações sobre as pessoas relacionadas aos usuários cadastrados em nosso sistema.";
    public static final String API_PESSOA_OPERATION_SUMMARY_CRIAR_PESSOA = "Criar PessoaEntity";

    public static final String API_PESSOA_OPERATION_JSON_DEPENDENTES = """
            [
                {
                    "nome": "Andre",
                        "sobrenome": "Andrade",
                        "cpf": "84483706004",
                        "dataNascimento": "22/06/1965",
                        "siglaSexo": "M",
                        "siglaParentesco": "P"
                },
                {
                    "nome": "Ana",
                        "sobrenome": "Andrade",
                        "cpf": "08062364003",
                        "dataNascimento": "01/01/1965",
                        "siglaSexo": "F",
                        "siglaParentesco": "M"
                },
                {
                    "nome": "Clara",
                        "sobrenome": "Andrade",
                        "cpf": "56485638091",
                        "dataNascimento": "01/01/1968",
                        "siglaSexo": "F",
                        "siglaParentesco": "F"
                }
            ]
            """;

    public static final String API_PESSOA_OPERATION_JSON_PESSOA_PARENT = """
                {
                    "nome": "Anderson",
                    "sobrenome": "Andrade",
                    "dataNascimento": "22/06/1965",
                    "cpf": "84483706004",
                    "siglaSexo": "M",
                    "siglaParentesco": "P"
                }
            """;
    public static final String API_PESSOA_OPERATION_JSON_CRIAR_PESSOA = """
                {
                    "nome": "Marcos",
                    "sobrenome": "Andrade",
                    "dataNascimento": "13/03/1995",
                    "cpf": "50297831054",
                    "siglaSexo": "M",
                    "siglaParentesco": "F",
                    "dependentes":
                    [
                        {
                            "nome": "Andre",
                                "sobrenome": "Andrade",
                                "cpf": "84483706004",
                                "dataNascimento": "22/06/1965",
                                "siglaSexo": "M",
                                "siglaParentesco": "P"
                        },
                        {
                            "nome": "Ana",
                                "sobrenome": "Andrade",
                                "cpf": "08062364003",
                                "dataNascimento": "01/01/1965",
                                "siglaSexo": "F",
                                "siglaParentesco": "M"
                        }
                    ]
                }
            """;
    public static final String API_PESSOA_OPERATION_SUMMARY_LISTAR_PESSOA = "Listar PessoaEntity";

    public static final String API_PESSOA_OPERATION_SUMMARY_DETALHAR_PESSOA = "Detalhar PessoaEntity";

    public static final String API_PESSOA_OPERATION_SUMMARY_EXCLUIR_PESSOA = "Excluir PessoaEntity";

    public static final String API_PESSOA_OPERATION_SUMMARY_ATUALIZAR_PESSOA = "Atualizar PessoaEntity";
}
