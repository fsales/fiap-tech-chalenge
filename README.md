![GitHub](https://img.shields.io/github/license/fsales/fiap-tech-chalenge)
![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/fsales/fiap-tech-chalenge)
![GitHub language count](https://img.shields.io/github/languages/count/fsales/fiap-tech-chalenge)
![GitHub top language](https://img.shields.io/github/languages/top/fsales/fiap-tech-chalenge)
![GitHub issues](https://img.shields.io/github/issues/fsales/fiap-tech-chalenge)

<p align="center">
 <img src="https://img.shields.io/static/v1?label=GitHub&message=@fsales&color=8257E5&labelColor=000000" alt="@fsales" />
 <img src="https://img.shields.io/static/v1?label=Tipo&message=Tech%20Chalenge&color=8257E5&labelColor=000000" alt="Tech Chalenge" />
</p>

# :bookmark_tabs: Tech Chalenge

> Tech Challenge para avaliação da Fase I da Pós Graduação em Arquitetura e Desenvolvimento Java.

- [:bookmark\_tabs: Tech Chalenge](#bookmark_tabs-tech-chalenge)
  - [🛠️ Linguagem e ferramentas](#️-linguagem-e-ferramentas)
  - [🏫 Dados Acadêmicos](#-dados-acadêmicos)
    - [🏬 Instituição](#-instituição)
    - [🧑🏻‍🎓Curso](#curso)
    - [Aluno](#aluno)
  - [Ferramentas](#ferramentas)
  - [Tecnologias](#tecnologias)
  - [Pré-requisitos](#pré-requisitos)
  - [Como Executar](#como-executar)
    - [Localmente](#localmente)
  - [:hammer: Funcionalidades do projeto](#hammer-funcionalidades-do-projeto)
    - [Endpoints](#endpoints)
      - [API](#api)
    - [Base de dados](#base-de-dados)
  - [Desafio encontrado durante o desenvolvimento](#desafio-encontrado-durante-o-desenvolvimento)
  - [Referência](#referência)

## 🛠️ Linguagem e ferramentas

[![logo java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=kofi&logoColor=white)](#)

[![logo spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](#)

 [![logo git](https://img.shields.io/badge/GIT-E44C30?style=for-the-badge&logo=git&logoColor=white)](#) [![logo github](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](#)

## 🏫 Dados Acadêmicos

### 🏬 Instituição

Faculdade FIAP

### 🧑🏻‍🎓Curso

Pós-Graduação em Arquitetura e Desenvolvimento Java

### Aluno

| [<img src="https://avatars.githubusercontent.com/u/816101?v=4" width=115><br><sub>Fábio de Oliveira Sales</sub>](https://github.com/fsales) |
| :---: |

[![Linkedin Badge](https://img.shields.io/badge/-Fábio%20Sales-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/fabio-oliveira-sales/)](https://www.linkedin.com/in/fabio-oliveira-sales/)
[![Gmail Badge](https://img.shields.io/badge/-fabio.oliveira.sales@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:fabio.oliveira.sales@gmail.com)](mailto:fabio.oliveira.sales@gmail.com)

## Ferramentas

- [IntelliJ IDEA](https://www.jetbrains.com/pt-br/idea/)
- [Postman](https://www.postman.com/)
- [Chrome](https://www.google.pt/intl/pt-PT/chrome/?brand=FKPE&gclid=EAIaIQobChMI8cT_xsr1_wIVA2GRCh0hxwthEAAYASAAEgK0h_D_BwE&gclsrc=aw.ds)
- [Git](https://git-scm.com/)

## Tecnologias

<details>

  <summary>Flyway</summary>

  > O [Flyway](<https://flywaydb.org>) é um framework que permite o versionamento e gerenciamento do Banco de dados, com ele podemos controlar as versões do banco de dados[^1].
</details>

<details>
  <summary>H2DataBase</summary>

  > [H2](https://www.h2database.com/html/main.html)
 é um sistema de gerenciamento de banco de dados relacional escrito em Java. Ele pode ser incorporado em aplicativos Java ou executado no modo cliente-servidor[^2].
</details>

<details>
  <summary>Java 17</summary>
  
  > [Java](https://docs.oracle.com/en/java/javase/17/index.html) é uma linguagem de programação e plataforma de computação liberada pela primeira vez pela Sun Microsystems em 1995. De um início humilde, ela evoluiu para uma grande participação no mundo digital dos dias atuais, oferecendo a plataforma confiável na qual muitos serviços e aplicativos são desenvolvidos. Produtos e serviços novos e inovadores projetados para o futuro continuam a confiar no Java também[^3].
</details>

<details>
  <summary>MapStruct</summary>

  > O [MapStruct](https://mapstruct.org/documentation/stable/reference/html/) é um gerador de código que simplifica bastante a implementação de mapeamentos entre tipos de bean Java com base em uma abordagem de convenção sobre configuração. O código de mapeamento gerado usa invocações simples de método e, portanto, é rápido, seguro e fácil de entender[^4].
</details>

<details>
  <summary>Spring Boot</summary>

  > O Java Spring Framework (Spring Framework) é um framework bastante conhecido de nível empresarial, de software livre, para criar aplicativos independentes de nível de produção que são executados na Java Virtual Machine (JVM)[^5].
  </br>O Java [Spring Boot](https://spring.io/projects/spring-boot) (Spring Boot) é uma ferramenta que facilita e agiliza o desenvolvimento de aplicativos da web e de microsserviços com o Spring Framework por meio de três principais recursos: </br>1. Autoconfiguração</br>2. Uma abordagem opinativa à configuração</br>3. A capacidade de criar aplicativos independentes
</details>

<details>
  <summary>Spring Data</summary>
  
  > O [Spring Data](https://spring.io/projects/spring-data) é o modelo de programação dentro do Spring Framework para acesso e manipulação de dados. Chegando com a intenção de facilitar a configuração e utilização com o seu banco de dados, seja ele relacional ou não, o Spring Data traz vários recursos bacanas para acelerar o nosso desenvolvimento[^6].
</details>

<details>
  <summary>SpringDoc OpenAPI 3</summary>

  > OpenAPI possui anotações a fim de facilitar a construção da documentação da sua API. Tais anotações estão compostas na biblioteca Documentation do framework Spring e podem ser acessadas na documentação do Swagger-api. A biblioteca [Spring Doc](https://springdoc.org) oferece ainda um plugin que possibilita a geração da documentação em tempo de build[^7].

</details>

<details>
  <summary>Project Lombok</summary>

  > O [Lombok](https://projectlombok.org/) é um framework para Java que permite escrever código eliminando a verbosidade, o que permite ganhar tempo de desenvolvimento para o que realmente é importante. Seu uso permite gerar em tempo de compilação os métodos getters e setters, métodos construtores, padrão builder e muito mais[^8].
</details>

## Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
[Git](https://git-scm.com), [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html).

## Como Executar

### Localmente

- Clonar repositório git
- Acessar o diretório **_fiap-tech-chalenge/eletro-tech_**
- Construir o projeto:

```
./mvnw clean package
```

- Executar:

```
java -jar eletro-tech/target/eletro-tech-0.0.1-SNAPSHOT.jar
```

A API poderá ser acessada em [localhost:8080/api](http://localhost:8080/api).
O Swagger poderá ser visualizado em [localhost:8080/api/swagger-ui/index.html](http://localhost:8080/api/swagger-ui/index.html)

## :hammer: Funcionalidades do projeto

- `API de gestão de pessoas`: A API de gestão de pessoas tem como objetivo permitir o cadastro e gerenciamento de informações sobre as pessoas relacionadas aos usuários cadastrados em nosso sistema.
- `API de Cadastro de Endereços`: tem como objetivo permitir o gerenciamento de informações sobre os endereços cadastrados em nosso sistema.
- `API de Gestão de Eletrodomésticos`: tem como objetivo permitir o cadastro e gerenciamento de informações sobre os aparelhos eletrônicos dos usuários cadastrados em nosso sistema.

### Endpoints

> Para fazer as requisições HTTP pode ser utilizado:

1. [CURL](https://curl.se/docs/manual.html)
2. [Swagger](http://localhost:8080/api/swagger-ui/index.html)
3. [Postman](https://www.postman.com/)

- [Collections](doc/postman-collections/Fase%201%20-%20API%20Eletro%20Tech.postman_collection.json)
- [Environment](doc/postman-collections/APi%20Eletro%20Tech%20-%20Dev.postman_environment.json)

#### API

- [Gestão de pessoas](doc/api-gestao-pessoas.md)
- [Cadastro de Endereços](/doc/api-cadastro-enderecos.md)
- [Gestão de eletrodomésticos](/doc/api-gestao-eletrodomestico.md)

### Base de dados

A base de dados e versionada utilizando a biblioteca Flyway.

- [scripts](/eletro-tech/src/main/resources/db/migration/)

## Desafio encontrado durante o desenvolvimento

> Durante o desenvolvimento do projeto da primeira fase, não foi encontrado muita dificuldade com o Framework Spring Boot. Por esse motivo foi foi adicionado os itens abaixo:
>
> - Documentação da API utilizando o SpringDoc.
> - Persistência dos dados utilizando o Spring Data e H2.

## Referência

[^1]: [FlyWay](<https://www.linkedin.com/pulse/porqu%C3%AA-e-como-usar-flyway-com-spring-mateus-cunha/?originalSubdomain=pt>).

[^2]: [H2](<https://camilacgs17.medium.com/como-configurar-e-utilizar-o-h2-no-springboot-e36c3cd378c8#:~:text=H2%20%C3%A9%20um%20sistema%20de,como%20Eclipse%20Public%20License%20original%20.>)

[^3]: [Java 17](<https://www.java.com/pt-BR/download/help/whatis_java.html#:~:text=Java%20%C3%A9%20uma%20linguagem%20de,servi%C3%A7os%20e%20aplicativos%20s%C3%A3o%20desenvolvidos>).

[^4]: [MapStruct](<https://medium.com/mobicareofficial/mapstruct-simplificando-mapeamento-de-dtos-em-java-c29135835c68>).

[^5]: [Spring Boot](<https://www.ibm.com/br-pt/topics/java-spring-boot#:~:text=O%20Java%20Spring%20Boot%20(Spring,capacidade%20de%20criar%20aplicativos%20independentes>).

[^6]: [Spring Data](<https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&cad=rja&uact=8&ved=2ahUKEwikx8XK4eT_AhXzLrkGHb3cBHYQFnoECA0QAw&url=https%3A%2F%2Fwww.zup.com.br%2Fblog%2Fspring-data-na-pratica%23%3A~%3Atext%3DO%2520Spring%2520Data%2520%25C3%25A9%2520o%2Cpara%2520acelerar%2520o%2520nosso%2520desenvolvimento.&usg=AOvVaw0QlwhtsULxop_krOEzeaCG&opi=89978449>).

[^7]: [SpringDoc OpenAPI 3](<https://tjf.totvs.com.br/docs/open-api>).

[^8]: [Project Lombok](<https://www.linkedin.com/pulse/como-usar-o-lombok-em-projetos-java-alex-jos%C3%A9-silva-msc/?originalSubdomain=pts>).
