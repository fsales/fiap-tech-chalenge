# API de Gestão de Eletrodomésticos

A API de gestão de eletrodomésticos tem como objetivo permitir o cadastro e gerenciamento de informações sobre os aparelhos eletrônicos dos usuários cadastrados em nosso sistema.

- [API de Gestão de Eletrodomésticos](#api-de-gestão-de-eletrodomésticos)
  - [Criar Eletrodoméstico](#criar-eletrodoméstico)
    - [\[POST\] /api/eletrodomesticos](#post-apieletrodomesticos)
  - [Atualizar Eletrodoméstico](#atualizar-eletrodoméstico)
    - [\[PUT\] /api/eletrodomesticos](#put-apieletrodomesticos)
  - [Listar Eletrodoméstico](#listar-eletrodoméstico)
    - [\[GET\] /api/eletrodomesticos](#get-apieletrodomesticos)
  - [Detalhar Eletrodoméstico](#detalhar-eletrodoméstico)
    - [\[GET\] /api/eletrodomesticos/{id}](#get-apieletrodomesticosid)
  - [Excluir Eletrodoméstico](#excluir-eletrodoméstico)
    - [\[DELETE\] /api/eletrodomesticos/{id}](#delete-apieletrodomesticosid)

## Criar Eletrodoméstico

### [POST] /api/eletrodomesticos

1. Swagger

```shell
http://127.0.0.1:8080/api/swagger-ui/index.html#/A%20API%20de%20gest%C3%A3o%20de%20eletrodom%C3%A9sticos/cadastrar_2
```

2. CURL

```shell
curl -X 'POST' \
  'http://127.0.0.1:8080/api/eletrodomesticos' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "idEndereco": "3d02f4c7-91d5-4f46-9ecd-5da4254cf5b0",
  "idPessoa": "fed3f974-3b1e-449d-bcd6-3a8450b09fb9",
  "nome": "Micro-ondas 20L",
  "modelo": "MT30S",
  "potencia": 1150,
  "fabricante": "Electrolux",
  "voltagem": 220,
  "tempoUsoDiario": 1
}'
```

<details>
<summary>Resposta</summary>

```json
{
  "id": "ffd7e307-97e6-41c7-8080-1eba5a6a1e64",
  "idPessoa": "fed3f974-3b1e-449d-bcd6-3a8450b09fb9",
  "idEndereco": "3d02f4c7-91d5-4f46-9ecd-5da4254cf5b0",
  "nome": "Micro-ondas 20L",
  "modelo": "MT30S",
  "potencia": 1150,
  "fabricante": "Electrolux",
  "voltagem": 220,
  "tempoUsoDiario": 1,
  "consumo": {
    "watt": 34,
    "unidadeMedida": "kwh/Mês"
  },
  "created": "2023-09-05T00:07:26.910378800Z",
  "updated": "2023-09-05T00:07:26.910378800Z",
  "pessoa": {
    "idPessoa": "fed3f974-3b1e-449d-bcd6-3a8450b09fb9",
    "nome": "Luiz",
    "sobrenome": "Silva de Castro",
    "tipoPessoa": "Titular"
  },
  "endereco": {
    "id": "3d02f4c7-91d5-4f46-9ecd-5da4254cf5b0",
    "nomeEndereco": "Minha casa",
    "cep": "01001000",
    "rua": "Praça da Sé",
    "complemento": "lado ímpar",
    "numero": 1024,
    "bairro": "Sé",
    "cidade": "São Paulo",
    "created": "2023-09-04T22:37:45.774856Z",
    "updated": "2023-09-04T22:37:45.774856Z",
    "siglaEstado": "SP",
    "nomeEstado": "São Paulo"
  }
}
```

</details>

## Atualizar Eletrodoméstico

### [PUT] /api/eletrodomesticos

1. Swagger

```shell
http://127.0.0.1:8080/api/swagger-ui/index.html#/A%20API%20de%20gest%C3%A3o%20de%20eletrodom%C3%A9sticos/atualizar_2
```

2. CURL

```shell
curl -X 'PUT' \
  'http://127.0.0.1:8080/api/eletrodomesticos' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "id": "ffd7e307-97e6-41c7-8080-1eba5a6a1e64",
  "idPessoa": "fed3f974-3b1e-449d-bcd6-3a8450b09fb9",
  "idEndereco": "3d02f4c7-91d5-4f46-9ecd-5da4254cf5b0",
  "nome": "Microondas",
  "modelo": "MRAS222",
  "potencia": 800,
  "fabricante": "Electrolux SA",
  "voltagem": 110,
  "tempoUsoDiario": 2
}'
```

<details>
<summary>Resposta</summary>

```json
{
  "id": "ffd7e307-97e6-41c7-8080-1eba5a6a1e64",
  "idPessoa": "fed3f974-3b1e-449d-bcd6-3a8450b09fb9",
  "idEndereco": "3d02f4c7-91d5-4f46-9ecd-5da4254cf5b0",
  "nome": "Microondas",
  "modelo": "MRAS222",
  "potencia": 800,
  "fabricante": "Electrolux SA",
  "voltagem": 110,
  "tempoUsoDiario": 2,
  "consumo": {
    "watt": 48,
    "unidadeMedida": "kwh/Mês"
  },
  "created": "2023-09-05T00:07:26.910379Z",
  "updated": "2023-09-05T00:07:26.910379Z",
  "pessoa": {
    "idPessoa": "fed3f974-3b1e-449d-bcd6-3a8450b09fb9",
    "nome": "Luiz",
    "sobrenome": "Silva de Castro",
    "tipoPessoa": "Titular"
  },
  "endereco": {
    "id": "3d02f4c7-91d5-4f46-9ecd-5da4254cf5b0",
    "nomeEndereco": "Minha casa",
    "cep": "01001000",
    "rua": "Praça da Sé",
    "complemento": "lado ímpar",
    "numero": 1024,
    "bairro": "Sé",
    "cidade": "São Paulo",
    "created": "2023-09-04T22:37:45.774856Z",
    "updated": "2023-09-04T22:37:45.774856Z",
    "siglaEstado": "SP",
    "nomeEstado": "São Paulo"
  }
}
```

</details>

## Listar Eletrodoméstico

### [GET] /api/eletrodomesticos

1. Swagger

```shell
http://127.0.0.1:8080/api/swagger-ui/index.html#/A%20API%20de%20gest%C3%A3o%20de%20eletrodom%C3%A9sticos/listar_1
```

2. CURL

```shell
curl -X 'GET' \
  'http://127.0.0.1:8080/api/eletrodomesticos?nome=Chuveiro%20El%C3%A9trico&modelo=MT30S&fabricante=LORENZETTI&potencia=7800&page=0&size=20' \
  -H 'accept: application/json'
 ```

  <details>
    <summary>Resposta</summary>

  ```json
  {
  "content": [
    {
      "id": "c9dbd0c4-bb7b-4903-8f84-841d5a8644df",
      "nome": "Chuveiro Elétrico",
      "modelo": "MT30S",
      "potencia": 7800,
      "fabricante": "LORENZETTI",
      "voltagem": 220,
      "tempoUsoDiario": 1,
      "consumo": {
        "watt": 234,
        "unidadeMedida": "kwh/Mês"
      },
      "pessoa": {
        "idPessoa": "608f3f7d-67da-4ea6-ba56-55d9a3721dd2",
        "nome": "Maria",
        "sobrenome": "Silva de Castro",
        "parent": {
          "idPessoa": "fed3f974-3b1e-449d-bcd6-3a8450b09fb9",
          "nome": "Luiz",
          "sobrenome": "Silva de Castro"
        },
        "tipoPessoa": "Dependente"
      },
      "endereco": {
        "id": "d86a5f0d-3145-496c-bc9c-1eff2ad89fca",
        "nomeEndereco": "Casa da família",
        "cep": "01001000",
        "rua": "Praça da Sé",
        "complemento": "lado ímpar",
        "numero": 1024,
        "bairro": "Sé",
        "cidade": "São Paulo",
        "siglaEstado": "SP",
        "nomeEstado": "São Paulo"
      }
    }
  ],
  "pageable": {
    "sort": [],
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
  "sort": [],
  "numberOfElements": 1,
  "first": true,
  "empty": false
}
  ```

  </details>

## Detalhar Eletrodoméstico

### [GET] /api/eletrodomesticos/{id}

1. Swagger

```shell
http://127.0.0.1:8080/api/swagger-ui/index.html#/A%20API%20de%20gest%C3%A3o%20de%20eletrodom%C3%A9sticos/detalhar_2
```

2. CURL

```shell
curl -X 'GET' \
  'http://127.0.0.1:8080/api/eletrodomesticos/c9dbd0c4-bb7b-4903-8f84-841d5a8644df' \
  -H 'accept: application/json'
 ```

  <details>
    <summary>Resposta</summary>

  ```json
{
  "id": "c9dbd0c4-bb7b-4903-8f84-841d5a8644df",
  "idPessoa": "608f3f7d-67da-4ea6-ba56-55d9a3721dd2",
  "idEndereco": "d86a5f0d-3145-496c-bc9c-1eff2ad89fca",
  "nome": "Chuveiro Elétrico",
  "modelo": "MT30S",
  "potencia": 7800,
  "fabricante": "LORENZETTI",
  "voltagem": 220,
  "tempoUsoDiario": 1,
  "consumo": {
    "watt": 234,
    "unidadeMedida": "kwh/Mês"
  },
  "created": "2023-09-04T23:09:30.097234Z",
  "updated": "2023-09-04T23:09:30.097234Z",
  "pessoa": {
    "idPessoa": "608f3f7d-67da-4ea6-ba56-55d9a3721dd2",
    "nome": "Maria",
    "sobrenome": "Silva de Castro",
    "parent": {
      "idPessoa": "fed3f974-3b1e-449d-bcd6-3a8450b09fb9",
      "nome": "Luiz",
      "sobrenome": "Silva de Castro",
      "tipoPessoa": "Titular"
    },
    "descricaoParentesco": "Filho(a)",
    "siglaParentesco": "F",
    "tipoPessoa": "Dependente"
  },
  "endereco": {
    "id": "d86a5f0d-3145-496c-bc9c-1eff2ad89fca",
    "nomeEndereco": "Casa da família",
    "cep": "01001000",
    "rua": "Praça da Sé",
    "complemento": "lado ímpar",
    "numero": 1024,
    "bairro": "Sé",
    "cidade": "São Paulo",
    "created": "2023-09-04T22:41:08.932746Z",
    "updated": "2023-09-04T22:41:08.932746Z",
    "siglaEstado": "SP",
    "nomeEstado": "São Paulo"
  }
}
  ```

  </details>

## Excluir Eletrodoméstico

### [DELETE] /api/eletrodomesticos/{id}

1. Swagger

```shell
http://127.0.0.1:8080/api/swagger-ui/index.html#/A%20API%20de%20gest%C3%A3o%20de%20eletrodom%C3%A9sticos/delete_2
```

2. CURL

```shell
curl -X 'DELETE' \
  'http://127.0.0.1:8080/api/eletrodomesticos/c9dbd0c4-bb7b-4903-8f84-841d5a8644df' \
  -H 'accept: */*'
```
