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
  "idPessoa": "6aaefc80-b9dc-4512-bbed-6dbebe396636",
  "idEndereco": "4bc6b235-84ae-40fe-8930-0ee0530fc170",
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
  "id": "af0f67c8-2cee-4cbc-be59-275f5c41da33",
  "idPessoa": "6aaefc80-b9dc-4512-bbed-6dbebe396636",
  "idEndereco": "4bc6b235-84ae-40fe-8930-0ee0530fc170",
  "nome": "Microondas",
  "modelo": "MRAS2",
  "potencia": 700,
  "fabricante": "Electrolux",
  "voltagem": 220,
  "tempoUsoDiario": 4,
  "created": "2023-08-28T23:06:27.045231800Z",
  "updated": "2023-08-28T23:06:27.045231800Z"
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
  "id": "71a0c60b-2da6-47c2-8402-51ef163f96bf",
  "nome": "Microondas",
  "modelo": "MRAS222",
  "potencia": 800,
  "fabricante": "Electrolux SA",
  "voltagem": 110,
  "tempoUsoDiario": 8
}'
```

<details>
<summary>Resposta</summary>

```json
{
  "id": "71a0c60b-2da6-47c2-8402-51ef163f96bf",
  "idPessoa": "6aaefc80-b9dc-4512-bbed-6dbebe396636",
  "idEndereco": "4bc6b235-84ae-40fe-8930-0ee0530fc170",
  "nome": "Microondas",
  "modelo": "MRAS222",
  "potencia": 800,
  "fabricante": "Electrolux SA",
  "voltagem": 110,
  "tempoUsoDiario": 8,
  "created": "2023-08-27T19:43:57.800257Z",
  "updated": "2023-08-28T23:19:51.680733Z"
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
  'http://127.0.0.1:8080/api/eletrodomesticos?page=0&size=20' \
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
http://127.0.0.1:8080/api/swagger-ui/index.html#/A%20API%20de%20gest%C3%A3o%20de%20eletrodom%C3%A9sticos/detalhar_2
```

2. CURL

```shell
curl -X 'GET' \
  'http://127.0.0.1:8080/api/eletrodomesticos/dde2e939-933a-4def-af7c-146b8320b485' \
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
http://127.0.0.1:8080/api/swagger-ui/index.html#/A%20API%20de%20gest%C3%A3o%20de%20eletrodom%C3%A9sticos/delete_2
```

2. CURL

```shell
curl -X 'DELETE' \
  'http://127.0.0.1:8080/api/eletrodomesticos/dde2e939-933a-4def-af7c-146b8320b485' \
  -H 'accept: */*'
```
