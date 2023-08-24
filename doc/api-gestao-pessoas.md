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
  "id": "ee607be1-25d6-4ae4-8db8-7022d7380c5e",
  "nome": "Marcos Andre",
  "sobrenome": "Andrade",
  "dataNascimento": "17/02/1995",
  "cpf": "50297831054",
  "created": "2023-07-04T16:37:17.331485300Z",
  "updated": "2023-07-04T16:37:17.331485300Z",
  "dependentes": [
    {
      "id": "94f0c37c-d0d8-427e-b9e4-06c1a6f117d1",
      "nome": "Andre",
      "sobrenome": "Andrade",
      "dataNascimento": "22/06/1965",
      "cpf": "84483706004",
      "created": "2023-07-04T16:37:17.360486600Z",
      "updated": "2023-07-04T16:37:17.360486600Z",
      "sexo": "Masculino",
      "parentesco": "Pai"
    },
    {
      "id": "44206f4d-333f-4d50-865d-d7b6259de94d",
      "nome": "Ana",
      "sobrenome": "Andrade",
      "dataNascimento": "01/01/1965",
      "cpf": "08062364003",
      "created": "2023-07-04T16:37:17.360486600Z",
      "updated": "2023-07-04T16:37:17.360486600Z",
      "sexo": "Feminino",
      "parentesco": "Mãe"
    },
    {
      "id": "fb70d8d2-012b-44a2-b91d-0f29329a9447",
      "nome": "Clara",
      "sobrenome": "Andrade",
      "dataNascimento": "01/01/1968",
      "cpf": "56485638091",
      "created": "2023-07-04T16:37:17.361488Z",
      "updated": "2023-07-04T16:37:17.361488Z",
      "sexo": "Feminino",
      "parentesco": "Filho(a)"
    }
  ],
  "sexo": "Masculino",
  "parentesco": "Filho(a)"
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
  "id": "f6c323ed-968f-43fc-aa3a-b25a764b4d5d",
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
curl -X 'PUT' \
  'http://127.0.0.1:8080/api/pessoas' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "id": "f6c323ed-968f-43fc-aa3a-b25a764b4d5d",
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
  'http://127.0.0.1:8080/api/pessoas?sobrenome=Andrade&page=0&size=20' \
  -H 'accept: application/json'
 ```

  <details>
    <summary>Resposta</summary>

  ```json
{
  "content": [
    {
      "id": "44b8fc05-6ae7-4657-9b6f-caaf2afbc11e",
      "nome": "Ana",
      "sobrenome": "Andrade",
      "dataNascimento": "01/01/1965",
      "cpf": "08062364003",
      "parent": {
        "id": "f15bfccc-3386-4c21-ac31-0d34d31db26d",
        "nome": "José",
        "sobrenome": "Andrade",
        "dataNascimento": "13/03/1995",
        "cpf": "50297831054",
        "created": "2023-08-24T17:21:54.670558Z",
        "updated": "2023-08-24T17:25:56.934279Z",
        "enderecos": [
          {
            "cep": "71200020",
            "rua": "SIA Trecho 2",
            "complemento": "",
            "numero": 104,
            "bairro": "Zona Industrial (Guará)",
            "cidade": "Brasília",
            "estado": "Distrito Federal"
          },
          {
            "cep": "71200021",
            "rua": "SIA Trecho 2",
            "complemento": "até 768 - lado par",
            "numero": 104,
            "bairro": "Zona Industrial (Guará)",
            "cidade": "Brasília",
            "estado": "Distrito Federal"
          }
        ],
        "parentesco": "Pai",
        "sexo": "Masculino"
      },
      "created": "2023-08-24T17:21:54.700554Z",
      "updated": "2023-08-24T17:21:54.700554Z",
      "enderecos": [
        {
          "cep": "71200020",
          "rua": "SIA Trecho 2",
          "complemento": "",
          "numero": 104,
          "bairro": "Zona Industrial (Guará)",
          "cidade": "Brasília",
          "estado": "Distrito Federal"
        }
      ],
      "parentesco": "Mãe",
      "sexo": "Feminino"
    },
    {
      "id": "1e49cb08-bdc3-4125-977c-f94b5d693efe",
      "nome": "Anderson",
      "sobrenome": "Andrade",
      "dataNascimento": "22/06/1965",
      "cpf": "84483706004",
      "parent": {
        "id": "f15bfccc-3386-4c21-ac31-0d34d31db26d",
        "nome": "José",
        "sobrenome": "Andrade",
        "dataNascimento": "13/03/1995",
        "cpf": "50297831054",
        "created": "2023-08-24T17:21:54.670558Z",
        "updated": "2023-08-24T17:25:56.934279Z",
        "enderecos": [
          {
            "cep": "71200020",
            "rua": "SIA Trecho 2",
            "complemento": "",
            "numero": 104,
            "bairro": "Zona Industrial (Guará)",
            "cidade": "Brasília",
            "estado": "Distrito Federal"
          },
          {
            "cep": "71200021",
            "rua": "SIA Trecho 2",
            "complemento": "até 768 - lado par",
            "numero": 104,
            "bairro": "Zona Industrial (Guará)",
            "cidade": "Brasília",
            "estado": "Distrito Federal"
          }
        ],
        "parentesco": "Pai",
        "sexo": "Masculino"
      },
      "created": "2023-08-24T17:21:54.699554Z",
      "updated": "2023-08-24T17:21:54.699554Z",
      "enderecos": [
        {
          "cep": "71200020",
          "rua": "SIA Trecho 2",
          "complemento": "",
          "numero": 104,
          "bairro": "Zona Industrial (Guará)",
          "cidade": "Brasília",
          "estado": "Distrito Federal"
        }
      ],
      "parentesco": "Pai",
      "sexo": "Masculino"
    },
    {
      "id": "f15bfccc-3386-4c21-ac31-0d34d31db26d",
      "nome": "José",
      "sobrenome": "Andrade",
      "dataNascimento": "13/03/1995",
      "cpf": "50297831054",
      "created": "2023-08-24T17:21:54.670558Z",
      "updated": "2023-08-24T17:25:56.934279Z",
      "dependentes": [
        {
          "id": "1e49cb08-bdc3-4125-977c-f94b5d693efe",
          "nome": "Anderson",
          "sobrenome": "Andrade",
          "dataNascimento": "22/06/1965",
          "cpf": "84483706004",
          "created": "2023-08-24T17:21:54.699554Z",
          "updated": "2023-08-24T17:21:54.699554Z",
          "enderecos": [
            {
              "cep": "71200020",
              "rua": "SIA Trecho 2",
              "complemento": "",
              "numero": 104,
              "bairro": "Zona Industrial (Guará)",
              "cidade": "Brasília",
              "estado": "Distrito Federal"
            }
          ],
          "parentesco": "Pai",
          "sexo": "Masculino"
        },
        {
          "id": "44b8fc05-6ae7-4657-9b6f-caaf2afbc11e",
          "nome": "Ana",
          "sobrenome": "Andrade",
          "dataNascimento": "01/01/1965",
          "cpf": "08062364003",
          "created": "2023-08-24T17:21:54.700554Z",
          "updated": "2023-08-24T17:21:54.700554Z",
          "enderecos": [
            {
              "cep": "71200020",
              "rua": "SIA Trecho 2",
              "complemento": "",
              "numero": 104,
              "bairro": "Zona Industrial (Guará)",
              "cidade": "Brasília",
              "estado": "Distrito Federal"
            }
          ],
          "parentesco": "Mãe",
          "sexo": "Feminino"
        }
      ],
      "enderecos": [
        {
          "cep": "71200020",
          "rua": "SIA Trecho 2",
          "complemento": "",
          "numero": 104,
          "bairro": "Zona Industrial (Guará)",
          "cidade": "Brasília",
          "estado": "Distrito Federal"
        },
        {
          "cep": "71200021",
          "rua": "SIA Trecho 2",
          "complemento": "até 768 - lado par",
          "numero": 104,
          "bairro": "Zona Industrial (Guará)",
          "cidade": "Brasília",
          "estado": "Distrito Federal"
        }
      ],
      "parentesco": "Pai",
      "sexo": "Masculino"
    }
  ],
  "pageable": {
    "sort": {
      "empty": false,
      "sorted": true,
      "unsorted": false
    },
    "offset": 0,
    "pageSize": 20,
    "pageNumber": 0,
    "unpaged": false,
    "paged": true
  },
  "last": true,
  "totalPages": 1,
  "totalElements": 3,
  "size": 20,
  "number": 0,
  "sort": {
    "empty": false,
    "sorted": true,
    "unsorted": false
  },
  "first": true,
  "numberOfElements": 3,
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
  'http://127.0.0.1:8080/api/pessoas/44206f4d-333f-4d50-865d-d7b6259de94d' \
  -H 'accept: application/json'
 ```

  <details>
    <summary>Resposta</summary>

  ```json
{
  "id": "1e49cb08-bdc3-4125-977c-f94b5d693efe",
  "nome": "Anderson",
  "sobrenome": "Andrade",
  "dataNascimento": "22/06/1965",
  "cpf": "84483706004",
  "parent": {
    "id": "f15bfccc-3386-4c21-ac31-0d34d31db26d",
    "nome": "José",
    "sobrenome": "Andrade",
    "dataNascimento": "13/03/1995",
    "cpf": "50297831054",
    "created": "2023-08-24T17:21:54.670558Z",
    "updated": "2023-08-24T17:25:56.934279Z",
    "enderecos": [
      {
        "cep": "71200020",
        "rua": "SIA Trecho 2",
        "complemento": "",
        "numero": 104,
        "bairro": "Zona Industrial (Guará)",
        "cidade": "Brasília",
        "estado": "Distrito Federal"
      },
      {
        "cep": "71200021",
        "rua": "SIA Trecho 2",
        "complemento": "até 768 - lado par",
        "numero": 104,
        "bairro": "Zona Industrial (Guará)",
        "cidade": "Brasília",
        "estado": "Distrito Federal"
      }
    ],
    "parentesco": "Pai",
    "sexo": "Masculino"
  },
  "created": "2023-08-24T17:21:54.699554Z",
  "updated": "2023-08-24T17:21:54.699554Z",
  "enderecos": [
    {
      "cep": "71200020",
      "rua": "SIA Trecho 2",
      "complemento": "",
      "numero": 104,
      "bairro": "Zona Industrial (Guará)",
      "cidade": "Brasília",
      "estado": "Distrito Federal"
    }
  ],
  "parentesco": "Pai",
  "sexo": "Masculino"
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
  'http://127.0.0.1:8080/api/pessoas/6c46153b-224d-4368-bf0b-f2df7603eea7' \
  -H 'accept: */*'
```
