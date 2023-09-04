# API de gestão de pessoas

A API de gestão de pessoas tem como objetivo permitir o cadastro e gerenciamento de informações sobre as pessoas
relacionadas aos usuários cadastrados em nosso sistema.

- [API de gestão de pessoas](#api-de-gestão-de-pessoas)
  - [Criar Pessoa](#criar-pessoa)
    - [\[POST\] /api/pessoas](#post-apipessoas)
  - [Atualizar Pessoa](#atualizar-pessoa)
    - [\[PUT\] /api/pessoas](#put-apipessoas)
  - [Listar Pessoas](#listar-pessoas)
    - [\[GET\] /api/pessoas](#get-apipessoas)
  - [Detalhar Pessoa](#detalhar-pessoa)
    - [\[GET\] /api/pessoas/{id}](#get-apipessoasid)
  - [Excluir Pessoa](#excluir-pessoa)
    - [\[DELETE\] /api/pessoas/{id}](#delete-apipessoasid)

## Criar Pessoa

### [POST] /api/pessoas

1. Swagger

```shell
http://127.0.0.1:8080/api/swagger-ui/index.html#/API%20de%20gest%C3%A3o%20de%20pessoas/cadastrar
```

2. CURL

```shell
curl -X 'POST' \
  'http://127.0.0.1:8080/api/pessoas' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "Marcos Andre",
  "sobrenome": "Andrade",
  "dataNascimento": "17/02/1995",
  "cpf": "50297831054",
  "siglaSexo": "M",
  "siglaParentesco": "F",
  "dependentes": [
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
}'
```

<details>
<summary>Resposta</summary>

```json
{
  "id": "29e99dd0-18e3-4440-8175-936352bf956e",
  "nome": "Marcos Andre",
  "sobrenome": "Andrade",
  "dataNascimento": "17/02/1995",
  "cpf": "50297831054",
  "created": "2023-09-04T23:52:06.605131400Z",
  "updated": "2023-09-04T23:52:06.605131400Z",
  "dependentes": [
    {
      "id": "b8186f57-51b1-44dc-ab10-c7b514f9bee2",
      "nome": "Andre",
      "sobrenome": "Andrade",
      "dataNascimento": "22/06/1965",
      "cpf": "84483706004",
      "created": "2023-09-04T23:52:06.669131Z",
      "updated": "2023-09-04T23:52:06.669131Z",
      "descricaoParentesco": "Pai",
      "siglaParentesco": "P",
      "tipoPessoa": "Dependente",
      "sexoDescricao": "Masculino"
    },
    {
      "id": "22792055-326f-4246-bab8-dce3248c12de",
      "nome": "Ana",
      "sobrenome": "Andrade",
      "dataNascimento": "01/01/1965",
      "cpf": "08062364003",
      "created": "2023-09-04T23:52:06.670130400Z",
      "updated": "2023-09-04T23:52:06.670130400Z",
      "descricaoParentesco": "Mãe",
      "siglaParentesco": "M",
      "tipoPessoa": "Dependente",
      "sexoDescricao": "Feminino"
    },
    {
      "id": "6d3246f3-bd4a-4b93-9a95-cfb45129bfd3",
      "nome": "Clara",
      "sobrenome": "Andrade",
      "dataNascimento": "01/01/1968",
      "cpf": "56485638091",
      "created": "2023-09-04T23:52:06.671131300Z",
      "updated": "2023-09-04T23:52:06.671131300Z",
      "descricaoParentesco": "Filho(a)",
      "siglaParentesco": "F",
      "tipoPessoa": "Dependente",
      "sexoDescricao": "Feminino"
    }
  ],
  "descricaoParentesco": "Filho(a)",
  "siglaParentesco": "F",
  "tipoPessoa": "Titular",
  "sexoDescricao": "Masculino"
}
```

</details>

## Atualizar Pessoa

### [PUT] /api/pessoas

1. Swagger

```shell
http://127.0.0.1:8080/api/swagger-ui/index.html#/API%20de%20gest%C3%A3o%20de%20pessoas/atualizar
```

2. CURL

```shell
curl -X 'PUT' \
  'http://127.0.0.1:8080/api/pessoas' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "id": "29e99dd0-18e3-4440-8175-936352bf956e",
  "nome": "Fernando",
  "sobrenome": "Teixeira de Oliveira",
  "dataNascimento": "17/02/1995",
  "cpf": "50297831054",
  "siglaSexo": "M",
  "siglaParentesco": "I",
  "dependentes": [
    {
      "id": "b8186f57-51b1-44dc-ab10-c7b514f9bee2",
      "nome": "Maria",
      "sobrenome": "Silva de Castro",
      "dataNascimento": "22/06/2001",
      "cpf": "84483706004",
      "siglaParentesco": "F",
      "siglaSexo": "F"
    },
    {
      "id": "22792055-326f-4246-bab8-dce3248c12de",
      "nome": "Andre",
      "sobrenome": "Silva de Castro",
      "dataNascimento": "22/07/2015",
      "cpf": "08062364003",
      "siglaParentesco": "F",
      "siglaSexo": "M"
    },
    {
      "id": "6d3246f3-bd4a-4b93-9a95-cfb45129bfd3",
      "nome": "Livia",
      "sobrenome": "Silva de Castro",
      "dataNascimento": "01/01/1985",
      "cpf": "56485638091",
      "siglaParentesco": "M",
      "siglaSexo": "F"
    }
  ]
}'
```

<details>
<summary>Resposta</summary>

```json
{
  "id": "29e99dd0-18e3-4440-8175-936352bf956e",
  "nome": "Fernando",
  "sobrenome": "Teixeira de Oliveira",
  "dataNascimento": "17/02/1995",
  "cpf": "50297831054",
  "created": "2023-09-04T23:52:06.605131Z",
  "updated": "2023-09-04T23:52:06.605131Z",
  "dependentes": [
    {
      "id": "b8186f57-51b1-44dc-ab10-c7b514f9bee2",
      "nome": "Maria",
      "sobrenome": "Silva de Castro",
      "dataNascimento": "22/06/2001",
      "cpf": "84483706004",
      "created": "2023-09-04T23:52:06.669131Z",
      "updated": "2023-09-04T23:52:06.669131Z",
      "descricaoParentesco": "Filho(a)",
      "siglaParentesco": "F",
      "tipoPessoa": "Dependente",
      "sexoDescricao": "Feminino"
    },
    {
      "id": "6d3246f3-bd4a-4b93-9a95-cfb45129bfd3",
      "nome": "Livia",
      "sobrenome": "Silva de Castro",
      "dataNascimento": "01/01/1985",
      "cpf": "56485638091",
      "created": "2023-09-04T23:52:06.671131Z",
      "updated": "2023-09-04T23:52:06.671131Z",
      "descricaoParentesco": "Mãe",
      "siglaParentesco": "M",
      "tipoPessoa": "Dependente",
      "sexoDescricao": "Feminino"
    },
    {
      "id": "22792055-326f-4246-bab8-dce3248c12de",
      "nome": "Andre",
      "sobrenome": "Silva de Castro",
      "dataNascimento": "22/07/2015",
      "cpf": "08062364003",
      "created": "2023-09-04T23:52:06.670130Z",
      "updated": "2023-09-04T23:52:06.670130Z",
      "descricaoParentesco": "Filho(a)",
      "siglaParentesco": "F",
      "tipoPessoa": "Dependente",
      "sexoDescricao": "Masculino"
    }
  ],
  "descricaoParentesco": "Irmão(a)",
  "siglaParentesco": "I",
  "tipoPessoa": "Titular",
  "sexoDescricao": "Masculino"
}
```

</details>

## Listar Pessoas

### [GET] /api/pessoas

1. Swagger

```shell
http://127.0.0.1:8080/api/swagger-ui/index.html#/API%20de%20gest%C3%A3o%20de%20pessoas/listarTodos
```

2. CURL

```shell
curl -X 'GET' \
  'http://127.0.0.1:8080/api/pessoas?nome=Maria&sobrenome=Silva%20de%20Castro&siglaParentesco=F&siglaSexo=F&cpf=64630752056&page=0&size=20' \
  -H 'accept: application/json'
 ```

  <details>
    <summary>Resposta</summary>

  ```json
{
  "content": [
    {
      "id": "608f3f7d-67da-4ea6-ba56-55d9a3721dd2",
      "nome": "Maria",
      "sobrenome": "Silva de Castro",
      "dataNascimento": "22/06/2001",
      "cpf": "64630752056",
      "parent": {
        "id": "fed3f974-3b1e-449d-bcd6-3a8450b09fb9",
        "nome": "Luiz",
        "sobrenome": "Silva de Castro",
        "dataNascimento": "01/05/1975",
        "cpf": "89004516000",
        "created": "2023-09-04T21:56:38.362334Z",
        "updated": "2023-09-04T21:56:38.362334Z",
        "enderecos": [
          {
            "id": "3d02f4c7-91d5-4f46-9ecd-5da4254cf5b0",
            "nomeEndereco": "Minha casa",
            "cep": "01001000",
            "rua": "Praça da Sé",
            "complemento": "lado ímpar",
            "numero": 1024,
            "bairro": "Sé",
            "cidade": "São Paulo",
            "nomeEstado": "São Paulo",
            "siglaEstado": "SP"
          }
        ],
        "tipoPessoa": "Titular",
        "sexoDescricao": "Masculino"
      },
      "created": "2023-09-04T21:56:38.363460Z",
      "updated": "2023-09-04T21:56:38.363460Z",
      "enderecos": [
        {
          "id": "d86a5f0d-3145-496c-bc9c-1eff2ad89fca",
          "nomeEndereco": "Casa da família",
          "cep": "01001000",
          "rua": "Praça da Sé",
          "complemento": "lado ímpar",
          "numero": 1024,
          "bairro": "Sé",
          "cidade": "São Paulo",
          "nomeEstado": "São Paulo",
          "siglaEstado": "SP"
        }
      ],
      "descricaoParentesco": "Filho(a)",
      "siglaParentesco": "F",
      "tipoPessoa": "Dependente",
      "sexoDescricao": "Feminino"
    }
  ],
  "pageable": {
    "sort": [
      {
        "direction": "ASC",
        "property": "nome",
        "ignoreCase": false,
        "nullHandling": "NATIVE",
        "ascending": true,
        "descending": false
      }
    ],
    "offset": 0,
    "pageNumber": 0,
    "pageSize": 20,
    "paged": true,
    "unpaged": false
  },
  "totalPages": 1,
  "totalElements": 1,
  "last": true,
  "size": 20,
  "number": 0,
  "sort": [
    {
      "direction": "ASC",
      "property": "nome",
      "ignoreCase": false,
      "nullHandling": "NATIVE",
      "ascending": true,
      "descending": false
    }
  ],
  "numberOfElements": 1,
  "first": true,
  "empty": false
}
  ```

  </details>

## Detalhar Pessoa

### [GET] /api/pessoas/{id}

1. Swagger

```shell
http://127.0.0.1:8080/api/swagger-ui/index.html#/API%20de%20gest%C3%A3o%20de%20pessoas/detalhar
```

2. CURL

```shell
curl -X 'GET' \
  'http://127.0.0.1:8080/api/pessoas/608f3f7d-67da-4ea6-ba56-55d9a3721dd2' \
  -H 'accept: application/json'
 ```

  <details>
    <summary>Resposta</summary>

  ```json
{
  "id": "608f3f7d-67da-4ea6-ba56-55d9a3721dd2",
  "nome": "Maria",
  "sobrenome": "Silva de Castro",
  "dataNascimento": "22/06/2001",
  "cpf": "64630752056",
  "parent": {
    "id": "fed3f974-3b1e-449d-bcd6-3a8450b09fb9",
    "nome": "Luiz",
    "sobrenome": "Silva de Castro",
    "dataNascimento": "01/05/1975",
    "cpf": "89004516000",
    "created": "2023-09-04T21:56:38.362334Z",
    "updated": "2023-09-04T21:56:38.362334Z",
    "enderecos": [
      {
        "id": "3d02f4c7-91d5-4f46-9ecd-5da4254cf5b0",
        "nomeEndereco": "Minha casa",
        "cep": "01001000",
        "rua": "Praça da Sé",
        "complemento": "lado ímpar",
        "numero": 1024,
        "bairro": "Sé",
        "cidade": "São Paulo",
        "nomeEstado": "São Paulo",
        "siglaEstado": "SP"
      }
    ],
    "tipoPessoa": "Titular",
    "sexoDescricao": "Masculino"
  },
  "created": "2023-09-04T21:56:38.363460Z",
  "updated": "2023-09-04T21:56:38.363460Z",
  "enderecos": [
    {
      "id": "d86a5f0d-3145-496c-bc9c-1eff2ad89fca",
      "nomeEndereco": "Casa da família",
      "cep": "01001000",
      "rua": "Praça da Sé",
      "complemento": "lado ímpar",
      "numero": 1024,
      "bairro": "Sé",
      "cidade": "São Paulo",
      "nomeEstado": "São Paulo",
      "siglaEstado": "SP"
    }
  ],
  "descricaoParentesco": "Filho(a)",
  "siglaParentesco": "F",
  "tipoPessoa": "Dependente",
  "sexoDescricao": "Feminino"
}
  ```

  </details>

## Excluir Pessoa

### [DELETE] /api/pessoas/{id}

1. Swagger

```shell
http://127.0.0.1:8080/api/swagger-ui/index.html#/API%20de%20gest%C3%A3o%20de%20pessoas/delete
```

2. CURL

```shell
curl -X 'DELETE' \
  'http://127.0.0.1:8080/api/pessoas/608f3f7d-67da-4ea6-ba56-55d9a3721dd2' \
  -H 'accept: */*'
```
