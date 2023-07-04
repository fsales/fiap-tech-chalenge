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
http://localhost:8080/api/swagger-ui/index.html#/A%20API%20de%20gest%C3%A3o%20de%20eletrodom%C3%A9sticos/cadastrar_2
```

2. CURL

```shell
curl -X 'POST' \
  'http://localhost:8080/api/eletrodomesticos' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "Microondas",
  "modelo": "MRAS2",
  "potencia": 700,
  "fabricante": "Electrolux",
  "voltagem": 220,
  "tempoUsoDiario": 4
}'
```

<details>
<summary>Resposta</summary>

```json
{
    "id": "dde2e939-933a-4def-af7c-146b8320b485",
    "nome": "Microondas",
    "modelo": "MRAS2",
    "potencia": 700,
    "fabricante": "Electrolux",
    "voltagem": 220,
    "tempoUsoDiario": 4,
    "created": "2023-07-04T12:46:27.606387600Z",
    "updated": "2023-07-04T12:46:27.606387600Z"
}
```

</details>

## Atualizar Eletrodoméstico

### [PUT] /api/eletrodomesticos

1. Swagger

```shell
http://localhost:8080/api/swagger-ui/index.html#/A%20API%20de%20gest%C3%A3o%20de%20eletrodom%C3%A9sticos/atualizar_2
```

2. CURL

```shell
curl -X 'PUT' \
  'http://localhost:8080/api/eletrodomesticos' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "id": "dde2e939-933a-4def-af7c-146b8320b485",
  "nome": "Microondas",
  "modelo": "MRAS2",
  "potencia": 700,
  "fabricante": "Electrolux",
  "voltagem": 220,
  "tempoUsoDiario": 4
}'
```

<details>
<summary>Resposta</summary>

```json
{
  "id": "dde2e939-933a-4def-af7c-146b8320b485",
  "nome": "Microondas",
  "modelo": "MRAS2",
  "potencia": 700,
  "fabricante": "Electrolux",
  "voltagem": 220,
  "tempoUsoDiario": 4,
  "created": "2023-07-04T12:46:27.606388Z",
  "updated": "2023-07-04T12:46:27.606388Z"
}
```

</details>

## Listar Eletrodoméstico

### [GET] /api/eletrodomesticos

1. Swagger

```shell
http://localhost:8080/api/swagger-ui/index.html#/A%20API%20de%20gest%C3%A3o%20de%20eletrodom%C3%A9sticos/listar_1
```

2. CURL

```shell
curl -X 'GET' \
  'http://localhost:8080/api/eletrodomesticos?page=0&size=20' \
  -H 'accept: application/json'
 ```

  <details>
    <summary>Resposta</summary>

  ```json
  {
  "content": [
    {
      "id": "89d6cc7a-05b9-43b3-a767-974b9d9583e5",
      "nome": "Microondas",
      "modelo": "MRAS2",
      "potencia": 700,
      "fabricante": "Electrolux",
      "voltagem": 220,
      "tempoUsoDiario": 4,
      "created": "2023-07-04T12:45:43.574459Z",
      "updated": "2023-07-04T12:45:43.574459Z"
    }
  ],
  "pageable": {
    "sort": {
      "empty": true,
      "sorted": false,
      "unsorted": true
    },
    "offset": 0,
    "pageSize": 20,
    "pageNumber": 0,
    "paged": true,
    "unpaged": false
  },
  "last": true,
  "totalPages": 1,
  "totalElements": 2,
  "size": 20,
  "number": 0,
  "sort": {
    "empty": true,
    "sorted": false,
    "unsorted": true
  },
  "first": true,
  "numberOfElements": 2,
  "empty": false
}
  ```

  </details>

## Detalhar Eletrodoméstico

### [GET] /api/eletrodomesticos/{id}

1. Swagger

```shell
http://localhost:8080/api/swagger-ui/index.html#/A%20API%20de%20gest%C3%A3o%20de%20eletrodom%C3%A9sticos/detalhar_2
```

2. CURL

```shell
curl -X 'GET' \
  'http://localhost:8080/api/eletrodomesticos/dde2e939-933a-4def-af7c-146b8320b485' \
  -H 'accept: application/json'
 ```

  <details>
    <summary>Resposta</summary>

  ```json
{
  "id": "dde2e939-933a-4def-af7c-146b8320b485",
  "nome": "Microondas",
  "modelo": "MRAS2",
  "potencia": 700,
  "fabricante": "Electrolux",
  "voltagem": 220,
  "tempoUsoDiario": 4,
  "created": "2023-07-04T12:46:27.606388Z",
  "updated": "2023-07-04T12:46:27.606388Z"
}
  ```

  </details>

## Excluir Eletrodoméstico

### [DELETE] /api/eletrodomesticos/{id}

1. Swagger

```shell
http://localhost:8080/api/swagger-ui/index.html#/A%20API%20de%20gest%C3%A3o%20de%20eletrodom%C3%A9sticos/delete_2
```

2. CURL

```shell
curl -X 'DELETE' \
  'http://localhost:8080/api/eletrodomesticos/dde2e939-933a-4def-af7c-146b8320b485' \
  -H 'accept: */*'
```
