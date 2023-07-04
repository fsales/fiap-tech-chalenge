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
http://localhost:8080/api/swagger-ui/index.html#/API%20de%20Cadastro%20de%20Endere%C3%A7os/cadastrar_1
```

2. CURL

```shell
curl -X 'POST' \
  'http://localhost:8080/api/enderecos' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "rua": "Nova Conquista",
  "complemento": "Bloco 5",
  "numero": 104,
  "bairro": "Conquista",
  "cidade": "Salvador",
  "siglaEstado": "BA"
}'
```

<details>
<summary>Resposta</summary>

```json
{
  "id": "bed06b7c-9767-4418-8096-6942dfa2646a",
  "rua": "Nova Conquista",
  "complemento": "Bloco 5",
  "numero": 104,
  "bairro": "Conquista",
  "cidade": "Salvador",
  "nomeEstado": "Bahia",
  "siglaEstado": "BA"
}
```

</details>

## Atualizar Endereço

### [PUT] /api/enderecos

1. Swagger

```shell
http://localhost:8080/api/swagger-ui/index.html#/API%20de%20Cadastro%20de%20Endere%C3%A7os/atualizar_1
```

2. CURL

```shell
curl -X 'PUT' \
  'http://localhost:8080/api/enderecos' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "id":"bed06b7c-9767-4418-8096-6942dfa2646a",
  "rua": "Nova Conquista II",
  "complemento": "Bloco 15",
  "numero": 10,
  "bairro": "Nova Morada",
  "cidade": "Correntina",
  "siglaEstado": "BA"
}'
```

<details>
<summary>Resposta</summary>

```json
{
  "id": "bed06b7c-9767-4418-8096-6942dfa2646a",
  "rua": "Nova Conquista II",
  "complemento": "Bloco 15",
  "numero": 10,
  "bairro": "Nova Morada",
  "cidade": "Correntina",
  "siglaEstado": "BA",
  "nomeEstado": "Bahia"
}
```

</details>

## Listar Endereços

### [GET] /api/enderecos

1. Swagger

```shell
http://localhost:8080/api/swagger-ui/index.html#/API%20de%20Cadastro%20de%20Endere%C3%A7os/listar
```

2. CURL

```shell
curl -X 'GET' \
  'http://localhost:8080/api/enderecos?page=0&size=20' \
  -H 'accept: application/json'
 ```

  <details>
    <summary>Resposta</summary>

  ```json
  {
  "content": [
    {
      "id": "bed06b7c-9767-4418-8096-6942dfa2646a",
      "rua": "Nova Conquista II",
      "complemento": "Bloco 15",
      "numero": 10,
      "bairro": "Nova Morada",
      "cidade": "Correntina",
      "siglaEstado": "BA",
      "nomeEstado": "Bahia"
    }
  ],
  "pageable": {
    "sort": {
      "empty": false,
      "sorted": true,
      "unsorted": false
    },
    "offset": 0,
    "pageNumber": 0,
    "pageSize": 20,
    "unpaged": false,
    "paged": true
  },
  "last": true,
  "totalElements": 1,
  "totalPages": 1,
  "size": 20,
  "number": 0,
  "sort": {
    "empty": false,
    "sorted": true,
    "unsorted": false
  },
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
http://localhost:8080/api/swagger-ui/index.html#/API%20de%20Cadastro%20de%20Endere%C3%A7os/detalhar_1
```

2. CURL

```shell
curl -X 'GET' \
  'http://localhost:8080/api/enderecos/bed06b7c-9767-4418-8096-6942dfa2646a' \
  -H 'accept: application/json'
 ```

  <details>
    <summary>Resposta</summary>

  ```json
{
  "id": "bed06b7c-9767-4418-8096-6942dfa2646a",
  "rua": "Nova Conquista II",
  "complemento": "Bloco 15",
  "numero": 10,
  "bairro": "Nova Morada",
  "cidade": "Correntina",
  "siglaEstado": "BA",
  "nomeEstado": "Bahia"
}
  ```

  </details>

## Excluir Endereço

### [DELETE] /api/enderecos/{id}

1. Swagger

```shell
http://localhost:8080/api/swagger-ui/index.html#/API%20de%20Cadastro%20de%20Endere%C3%A7os/delete_1
```

2. CURL

```shell
curl -X 'DELETE' \
  'http://localhost:8080/api/enderecos/bed06b7c-9767-4418-8096-6942dfa2646a' \
  -H 'accept: */*'
```
