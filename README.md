# Shortly Url

Shortly é um serviço de encurtamento de URLs desenvolvido em Java utilizando o framework Spring Boot. Ele permite que os usuários convertam URLs longas em URLs curtas e gerenciem redirecionamentos de forma eficiente.

## Funcionalidades

- Encurtar URLs longas em URLs curtas
- Redirecionar URLs curtas para suas URLs longas originais

## Requisitos

- Java 11 ou superior
- Maven 3.6.3 ou superior

## Configuração do Projeto

### 1. Clonar o Repositório

```
git clone https://github.com/alexsouza10/shortly.git

cd shortly
```

### 2. Configuração do Banco de Dados

A aplicação utiliza um banco de dados em memória H2 para armazenamento de dados. As configurações do banco de dados estão no arquivo `src/main/resources/application.properties`.

### 3. Executar a Aplicação

Para iniciar a aplicação, utilize o Maven:

```
mvn spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`.

## Endpoints da API

### Encurtar uma URL

- **URL:** `/api/shorten`
- **Método:** `POST`
- **Content-Type:** `application/json`
- **Body:**

```json
{
  "longUrl": "https://www.example.com"
}
```

- **Resposta:**

```json
{
  "shortUrl": "abc123"
}
```

### Redirecionar uma URL curta

- **URL:** `/api/{shortUrl}`
- **Método:** `GET`
- **Resposta:**

```json
{
  "message": "Redirecting to: https://www.example.com"
}
```

## Testando com Postman

### Encurtar uma URL

1. Abra o Postman.
2. Crie uma nova requisição `POST` para `http://localhost:8080/api/shorten`.
3. No corpo da requisição, selecione `raw` e `JSON` e adicione o seguinte JSON:

```json
{
  "longUrl": "https://www.example.com"
}
```

4. Envie a requisição. A resposta deve conter a URL curta gerada.

### Redirecionar uma URL curta

1. Crie uma nova requisição `GET` para `http://localhost:8080/api/{shortUrl}`, substituindo `{shortUrl}` pela URL curta gerada.
2. Envie a requisição. A resposta deve indicar a URL longa original.

## Estrutura do Projeto

```
shortly
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── shortly
│   │   │           └── api
│   │   │               ├── ApiApplication.java
│   │   │               ├── controller
│   │   │               │   └── UrlMappingController.java
│   │   │               ├── model
│   │   │               │   └── UrlMapping.java
│   │   │               ├── repository
│   │   │               │   └── UrlMappingRepository.java
│   │   │               └── service
│   │   │                   └── UrlMappingService.java
│   │   └── resources
│   │       └── application.properties
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## Contribuição

Sinta-se à vontade para contribuir com melhorias para este projeto. Você pode abrir issues ou enviar pull requests.

## Licença

Este projeto está licenciado sob a MIT License. Veja o arquivo `LICENSE` para mais detalhes.