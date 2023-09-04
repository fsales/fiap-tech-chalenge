# API de Cadastro de Endereços

A API de gestão de endereços tem como objetivo permitir o gerenciamento de informações sobre os endereços cadastrados em nosso sistema.

- [API de Cadastro de Endereços](#api-de-cadastro-de-endereços)
  - [Criar Endereço](#criar-endereço)
    - [\[POST\] /api/enderecos](#post-apienderecos)
  - [Atualizar Endereço](#atualizar-endereço)
    - [\[PUT\] /api/enderecos](#put-apienderecos)
  - [Listar Endereços](#listar-endereços)
    - [\[GET\] /api/enderecos](#get-apienderecos)
  - [Detalhar Endereços](#detalhar-endereços)
    - [\[GET\] /api/enderecos/{id}](#get-apienderecosid)
  - [Excluir Endereço](#excluir-endereço)
    - [\[DELETE\] /api/enderecos/{id}](#delete-apienderecosid)

## Criar Endereço

### [POST] /api/enderecos

1. Swagger

```shell
http://127.0.0.1:8080/api/swagger-ui/index.html#/API%20de%20Cadastro%20de%20Endere%C3%A7os/cadastrar_1
```

2. CURL

```shell
curl -X 'POST' \
  'http://127.0.0.1:8080/api/enderecos' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "idPessoa": "608f3f7d-67da-4ea6-ba56-55d9a3721dd2",
  "nomeEndereco": "Minha casa",
  "cep": "01001000",
  "rua": "Praça da Sé",
  "complemento": "lado ímpar",
  "numero": 1024,
  "bairro": "Sé",
  "cidade": "São Paulo",
  "siglaEstado": "SP"
}'
```

<details>
<summary>Resposta</summary>

```json
{
  "id": "2cf2e158-6c1f-4168-a405-f5337828914b",
  "idPessoa": "608f3f7d-67da-4ea6-ba56-55d9a3721dd2",
  "nomeEndereco": "Minha casa",
  "cep": "01001000",
  "rua": "Praça da Sé",
  "complemento": "lado ímpar",
  "numero": 1024,
  "bairro": "Sé",
  "cidade": "São Paulo",
  "siglaEstado": "SP",
  "nomeEstado": "São Paulo",
  "created": "2023-09-05T00:01:33.516778400Z",
  "updated": "2023-09-05T00:01:33.516778400Z"
}
```

</details>

## Atualizar Endereço

### [PUT] /api/enderecos

1. Swagger

```shell
http://127.0.0.1:8080/api/swagger-ui/index.html#/API%20de%20Cadastro%20de%20Endere%C3%A7os/atualizar_1
```

2. CURL

```shell
curl -X 'PUT' \
  'http://127.0.0.1:8080/api/enderecos' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "id": "2cf2e158-6c1f-4168-a405-f5337828914b",
  "idPessoa": "608f3f7d-67da-4ea6-ba56-55d9a3721dd2",
  "nomeEndereco": "Minha casa",
  "cep": "91040000",
  "rua": "Rua Domingos Rubbo",
  "complemento": "BL 16",
  "numero": 35,
  "bairro": "Cristo Redentor",
  "cidade": "Porto Alegre",
  "siglaEstado": "RS"
}'
```

<details>
<summary>Resposta</summary>

```json
{
  "id": "2cf2e158-6c1f-4168-a405-f5337828914b",
  "idPessoa": "608f3f7d-67da-4ea6-ba56-55d9a3721dd2",
  "nomeEndereco": "Minha casa",
  "cep": "91040000",
  "rua": "Rua Domingos Rubbo",
  "complemento": "BL 16",
  "numero": 35,
  "bairro": "Cristo Redentor",
  "cidade": "Porto Alegre",
  "siglaEstado": "RS",
  "nomeEstado": "Rio Grande do Sul",
  "created": "2023-09-05T00:01:33.516778Z",
  "updated": "2023-09-05T00:01:33.516778Z"
}
```

</details>

## Listar Endereços

### [GET] /api/enderecos

1. Swagger

```shell
http://127.0.0.1:8080/api/swagger-ui/index.html#/API%20de%20Cadastro%20de%20Endere%C3%A7os/listar
```

2. CURL

```shell
curl -X 'GET' \
  'http://127.0.0.1:8080/api/enderecos?idPessoa=608f3f7d-67da-4ea6-ba56-55d9a3721dd2&rua=Pra%C3%A7a%20da%20S%C3%A9&bairro=S%C3%A9&cidade=S%C3%A3o%20Paulo&siglaEstado=SP&page=0&size=20' \
  -H 'accept: application/json'
 ```

  <details>
    <summary>Resposta</summary>

  ```json
  {
  "content": [
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
      "siglaEstado": "SP",
      "pessoa": {
        "idPessoa": "608f3f7d-67da-4ea6-ba56-55d9a3721dd2",
        "nome": "Maria",
        "sobrenome": "Silva de Castro",
        "parent": {
          "idPessoa": "fed3f974-3b1e-449d-bcd6-3a8450b09fb9",
          "nome": "Luiz",
          "sobrenome": "Silva de Castro"
        },
        "parentesco": "F",
        "tipoPessoa": "Dependente"
      },
      "created": "2023-09-04T22:41:08.932746Z",
      "updated": "2023-09-04T22:41:08.932746Z"
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

## Detalhar Endereços

### [GET] /api/enderecos/{id}

1. Swagger

```shell
http://127.0.0.1:8080/api/swagger-ui/index.html#/API%20de%20Cadastro%20de%20Endere%C3%A7os/detalhar_1
```

2. CURL

```shell
curl -X 'GET' \
  'http://127.0.0.1:8080/api/enderecos/2cf2e158-6c1f-4168-a405-f5337828914b/pessoa/608f3f7d-67da-4ea6-ba56-55d9a3721dd2' \
  -H 'accept: application/json'
 ```

  <details>
    <summary>Resposta</summary>

  ```json
{
  "id": "2cf2e158-6c1f-4168-a405-f5337828914b",
  "idPessoa": "608f3f7d-67da-4ea6-ba56-55d9a3721dd2",
  "nomeEndereco": "Minha casa",
  "cep": "91040000",
  "rua": "Rua Domingos Rubbo",
  "complemento": "BL 16",
  "numero": 35,
  "bairro": "Cristo Redentor",
  "cidade": "Porto Alegre",
  "siglaEstado": "RS",
  "nomeEstado": "Rio Grande do Sul",
  "created": "2023-09-05T00:01:33.516778Z",
  "updated": "2023-09-05T00:02:16.401542Z"
}
  ```

  </details>

## Excluir Endereço

### [DELETE] /api/enderecos/{id}

1. Swagger

```shell
http://127.0.0.1:8080/api/swagger-ui/index.html#/API%20de%20Cadastro%20de%20Endere%C3%A7os/delete_1
```

2. CURL

```shell
curl -X 'DELETE' \
  'http://127.0.0.1:8080/api/enderecos/2cf2e158-6c1f-4168-a405-f5337828914b/pessoa/608f3f7d-67da-4ea6-ba56-55d9a3721dd2' \
  -H 'accept: */*'
```
