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
  "idPessoa": "6bdfe9d7-b8ca-48db-b1b9-8c1e58573cf2",
  "nomeEndereco": "Minha Casa",
  "cep": "01001000",
  "rua": "Praça da Sé",
  "complemento": "lado ímpar",
  "numero": 10,
  "bairro": "Sé",
  "cidade": "São Paulo",
  "siglaEstado": "SP"
}'
```

<details>
<summary>Resposta</summary>

```json
{
  "id": "4603b9ae-4a82-4222-8143-4e681cd626bf",
  "nomeEndereco": "Minha Casa",
  "cep": "01001000",
  "rua": "Praça da Sé",
  "complemento": "lado ímpar",
  "numero": 10,
  "bairro": "Sé",
  "cidade": "São Paulo",
  "created": "2023-08-27T18:57:25.537450500Z",
  "updated": "2023-08-27T18:57:25.537450500Z",
  "nomeEstado": "São Paulo",
  "siglaEstado": "SP"
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
  "id": "4603b9ae-4a82-4222-8143-4e681cd626bf",
  "nomeEndereco": "Minha Casa 2",
  "cep": "01001000",
  "rua": "Praça da Sé",
  "complemento": "lado ímpar",
  "numero": 11,
  "bairro": "Sé",
  "cidade": "São Paulo",
  "siglaEstado": "SP"
}'
```

<details>
<summary>Resposta</summary>

```json
{
  "id": "4603b9ae-4a82-4222-8143-4e681cd626bf",
  "nomeEndereco": "Minha Casa 2",
  "cep": "01001000",
  "rua": "Praça da Sé",
  "complemento": "lado ímpar",
  "numero": 11,
  "bairro": "Sé",
  "cidade": "São Paulo",
  "created": "2023-08-27T18:57:25.537451Z",
  "updated": "2023-08-27T19:06:43.548875100Z",
  "siglaEstado": "SP",
  "nomeEstado": "São Paulo"
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
  'http://127.0.0.1:8080/api/enderecos?idPessoa=6bdfe9d7-b8ca-48db-b1b9-8c1e58573cf2&rua=SIA%20Trecho%202&bairro=Zona%20Industrial&cidade=Bras%C3%ADlia&siglaEstado=df&page=0&size=20' \
  -H 'accept: application/json'
 ```

  <details>
    <summary>Resposta</summary>

  ```json
  {
  "content": [
    {
      "id": "6d2c13ef-7028-4741-9bac-a75f5c5cfa96",
      "nomeEndereco": "Casa do meu filho",
      "cep": "71200021",
      "rua": "SIA Trecho 2",
      "complemento": "até 768 - lado par",
      "numero": 104,
      "bairro": "Zona Industrial (Guará)",
      "cidade": "Brasília",
      "pessoa": {
        "idPessoa": "6bdfe9d7-b8ca-48db-b1b9-8c1e58573cf2",
        "nome": "Marcos",
        "sobrenome": "Andrade",
        "parent": {}
      },
      "created": "2023-08-27T18:50:01.493630Z",
      "updated": "2023-08-27T18:50:01.493630Z",
      "siglaEstado": "DF",
      "nomeEstado": "Distrito Federal"
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
  "last": true,
  "totalPages": 1,
  "totalElements": 1,
  "size": 20,
  "number": 0,
  "sort": [],
  "first": true,
  "numberOfElements": 1,
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
  'http://127.0.0.1:8080/api/enderecos/4bc6b235-84ae-40fe-8930-0ee0530fc170' \
  -H 'accept: application/json'
 ```

  <details>
    <summary>Resposta</summary>

  ```json
{
  "id": "4bc6b235-84ae-40fe-8930-0ee0530fc170",
  "nomeEndereco": "Minha Casa 2",
  "cep": "01001000",
  "rua": "Praça da Sé",
  "complemento": "lado ímpar",
  "numero": 11,
  "bairro": "Sé",
  "cidade": "São Paulo",
  "created": "2023-08-27T18:57:25.537451Z",
  "updated": "2023-08-27T19:06:43.548875Z",
  "siglaEstado": "SP",
  "nomeEstado": "São Paulo"
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
  'http://127.0.0.1:8080/api/enderecos/bed06b7c-9767-4418-8096-6942dfa2646a' \
  -H 'accept: */*'
```
