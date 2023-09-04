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

    public static final String API_PESSOA_OPERATION_JSON_ATUALIZAR_DEPENDENTES = """
            [
                {
                   "id": "608f3f7d-67da-4ea6-ba56-55d9a3721dd2",
                   "nome": "Maria",
                   "sobrenome": "Silva de Castro",
                   "dataNascimento": "22/06/2001",
                   "cpf": "64630752056",
                   "siglaParentesco": "F",
                   "siglaSexo": "F"
                 },
                 {
                   "id": "f490d55b-a411-4b9b-85d0-f81157dba97f",
                   "nome": "Andre",
                   "sobrenome": "Silva de Castro",
                   "dataNascimento": "22/07/2015",
                   "cpf": "66547968022",
                   "siglaParentesco": "F",
                   "siglaSexo": "M"
                 },
                 {
                   "id": "5f45e907-a9d8-4455-8c98-54970d66f60d",
                   "nome": "Livia",
                   "sobrenome": "Silva de Castro",
                   "dataNascimento": "01/01/1985",
                   "cpf": "90663099030",
                   "siglaParentesco": "M",
                   "siglaSexo": "F"
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
