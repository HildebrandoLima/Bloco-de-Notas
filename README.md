# Bloco de Notas

Desafio do bootcamp da DIO, conste em criar uma API com spting boot de sua escolha. Dentro do tema, eu resolvi abordar um serviço simples de CRUD de um bloco de notas.

### Aplicação Web desenvolvida com:<br />
- Java/Spring Boot;
- MySQL.

### Funcionalidades
- CRUD de notas.

### Requesitos necessários para executar o projeto:
- Instalar o git;
- Instalar o Java JDK;
- Instalar o Postman ou Insomnia;
- Instalar uma IDE de sua escolha (Eclipse / IntelliJ / VSCode);
- Instalar um cliente SQL de sua escolha (DBeaver / MySQL WorkBench).

### Executar o projeto:
- Clone: `https://github.com/HildebrandoLima/bloco-de-notas.git`
- Abra sua IDE;
- Configure o arquivo application.properties para conectar ao banco.
- Abra no link: `http://localhost:8080/api/nota`

- ### Criando o Banco de de Dados:

> No seu application.properties adicione da seguinte forma:<br />

> spring.datasource.url=jdbc:mysql://localhost:3306/db_name<br />
> spring.datasource.username=db_user<br />
> spring.datasource.password=db_password<br />
> spring.jpa.hibernate.ddl-auto=update<br />
> spring.jpa.show-sql=true<br />

## API Documentação

### Nota

<details>
<summary>Detalhes</summary>

### Rotas

| MÉTODO |   ROTA    |
|--------|-----------|
|  GET   | /api/nota |
|--------|-----------|
|  GET   | /api/nota |
|--------|-----------|
|  POST  | /api/nota |
|--------|-----------|
|  PUT   | /api/nota |
|--------|-----------|
| DELETE | /api/nota |

</details>

<details>
<summary>Detalhes</summary>

### Body

```
{
    "titulo": "Oi, eu sou um título",
    "texto": "Oi, eu sou um texto"
}
```

</details>

<details>
<summary>Detalhes</summary>

### Response

```
{
    "message": "Solicitação válida.",
    "data": [],
    "status": 200
}
```


```
{
    "message": "Solicitação inválida.",
    "data": [],
    "status": 400
}
```

```
{
    "message": "Registro não encontrado.",
    "data": [],
    "status": 404
}
```

```
{
    "message": "Registro já existente.",
    "data": [],
    "status": 409,
    "details": ""
}
```

</details>
