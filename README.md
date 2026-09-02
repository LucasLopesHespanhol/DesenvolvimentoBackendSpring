# Desenvolvimento Backend com Spring ☕🌱

Repositório destinado aos estudos, atividades e projetos desenvolvidos durante a disciplina **Desenvolvimento Backend com Spring**.

O projeto registra a evolução das aulas, desde os fundamentos do Java e do ecossistema Spring até a criação de APIs REST, persistência de dados com Spring Data JPA, banco H2 e relacionamentos entre entidades.

## 📚 Sobre a disciplina

A disciplina utiliza **Java, Spring Framework e Spring Boot** para o desenvolvimento de aplicações backend.

Durante as aulas, são estudados conceitos como:

- Java e JVM;
- Spring Framework e Spring Boot;
- Inversão de Controle (IoC);
- Injeção de Dependência (DI);
- APIs REST;
- métodos e códigos de status HTTP;
- arquitetura em camadas;
- Spring Data JPA;
- persistência com banco H2;
- relacionamentos entre entidades;
- inicialização de dados com `CommandLineRunner`;
- robustez, escalabilidade e tolerância a falhas;
- monólitos, microsserviços e sistemas distribuídos.

## 🛠️ Tecnologias utilizadas

- Java 21
- Spring Boot 4.1.0
- Spring Web MVC
- Spring Data JPA
- H2 Database
- Lombok
- Maven
- Bruno API Client

## 📂 Organização do projeto

```text
DesenvolvimentoBackendSpring/
├── DevSpring-Bruno/
│   ├── Aula01/
│   ├── Aula02/
│   ├── Aula03/
│   ├── Aula04/
│   └── Aula05/
├── src/
│   ├── main/
│   │   ├── java/com/example/DevSpring/
│   │   │   ├── Aula01/
│   │   │   ├── Aula02/
│   │   │   ├── Aula03/
│   │   │   └── Aula04/
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml
└── README.md
```

As classes recebem uma numeração correspondente à aula em que foram criadas, como `ProdutoController01`, `Cliente03` e `ClienteRepository04`.

## 🗓️ Evolução das aulas

### Aula 01 — Introdução ao Spring e Controllers

Primeiro contato com Spring Boot, criação de controllers e implementação de endpoints básicos.

Principais conteúdos:

- estrutura inicial de um projeto Spring Boot;
- `@RestController`;
- `@RequestMapping`;
- `@GetMapping`, `@PostMapping`, `@PutMapping` e `@DeleteMapping`;
- parâmetros com `@PathVariable` e `@RequestParam`;
- corpo da requisição com `@RequestBody`;
- respostas HTTP com `ResponseEntity`.

Endpoints implementados:

| Método | Endpoint                 | Descrição                                           |
| ------ | ------------------------ | --------------------------------------------------- |
| GET    | `/hello`                 | Retorna uma mensagem de apresentação do Spring Boot |
| GET    | `/aula01-produto`        | Simula a listagem de produtos                       |
| POST   | `/aula01-produto`        | Simula o cadastro de um produto                     |
| PUT    | `/aula01-produto/{id}`   | Simula a atualização de um produto                  |
| DELETE | `/aula01-produto/{id}`   | Simula a exclusão de um produto                     |
| GET    | `/aula01-usuario/{id}`   | Busca um usuário pelo ID                            |
| GET    | `/aula01-usuario/buscar` | Busca por nome e cidade usando query parameters     |

### Aula 02 — Camada Controller e HTTP

Desenvolvimento de controllers com diferentes formas de entrada e saída de dados.

Principais conteúdos:

- verbos HTTP;
- códigos de status;
- headers de requisição;
- query parameters;
- validações básicas;
- consumo de JSON;
- produção de XML;
- utilização inicial de DTO.

Controllers desenvolvidos:

- `VendaController02`;
- `ClienteController02`;
- `PedidoController02`;
- `ProdutoController02`;
- `AutenticacaoController02`;
- `RelatorioController02`.

Endpoints implementados:

| Método | Endpoint                     | Descrição                                 |
| ------ | ---------------------------- | ----------------------------------------- |
| GET    | `/aula02-venda/{id}`         | Simula a busca de uma venda               |
| POST   | `/aula02-venda`              | Simula o cadastro de uma venda            |
| GET    | `/aula02-cliente`            | Busca cliente por nome e cidade           |
| GET    | `/aula02-pedido`             | Lista os pedidos                          |
| POST   | `/aula02-pedido`             | Simula o cadastro de um pedido            |
| PUT    | `/aula02-produto/{id}`       | Atualiza um produto                       |
| DELETE | `/aula02-produto/{id}`       | Exclui um produto                         |
| GET    | `/aula02-autenticacao/login` | Simula autenticação por headers           |
| POST   | `/aula02-relatorio`          | Recebe JSON e devolve um relatório em XML |

O endpoint de autenticação utiliza os headers:

```text
usuario: lucas
senha: 123456
```

O endpoint de relatório recebe:

```json
{
  "tipo": "vendas"
}
```

E produz uma resposta em XML.

Também foram estudados conceitos relacionados à robustez de aplicações, como chamadas locais e remotas, timeouts, falha rápida, retries, idempotência e custos da adoção de sistemas distribuídos.

### Aula 03 — Spring Data JPA e banco H2

Introdução à persistência de dados e à camada Repository.

Principais conteúdos:

- criação de entidades com `@Entity`;
- chaves primárias com `@Id`;
- geração automática de IDs;
- interfaces que estendem `JpaRepository`;
- operações de persistência;
- consultas derivadas do Spring Data;
- injeção de repositórios nos controllers;
- utilização do banco H2 em memória.

Entidades desenvolvidas:

- `Cliente03`;
- `Produto03`;
- `Pedido03`.

Consultas derivadas utilizadas:

```java
List<Produto03> findByNomeContainingIgnoreCase(String nome);
```

```java
List<Pedido03> findByData(LocalDate data);
```

Endpoints implementados:

| Método | Endpoint                         | Descrição                          |
| ------ | -------------------------------- | ---------------------------------- |
| GET    | `/aula03-cliente`                | Lista os clientes persistidos      |
| POST   | `/aula03-cliente`                | Cadastra um cliente                |
| GET    | `/aula03-produto`                | Lista produtos ou filtra pelo nome |
| POST   | `/aula03-produto`                | Cadastra um produto                |
| GET    | `/aula03-pedido?data=AAAA-MM-DD` | Busca pedidos por data             |
| POST   | `/aula03-pedido`                 | Cadastra um pedido                 |

Exemplo de filtro de produtos:

```text
GET /aula03-produto?nome=Produto
```

Exemplo de busca de pedidos:

```text
GET /aula03-pedido?data=2026-08-26
```

### Aula 04 — CommandLineRunner e Mini-CRM

Utilização do `CommandLineRunner` para inserir dados automaticamente após a inicialização da aplicação.

Principais conteúdos:

- criação de um componente de inicialização;
- injeção de repositórios por construtor;
- inserção automática de registros;
- relacionamento `@OneToMany`;
- relacionamento `@ManyToOne`;
- associação entre clientes e contatos;
- desenvolvimento de um Mini-CRM.

Entidades do Mini-CRM:

```text
Cliente
├── id
├── nome
├── email
└── contatos

Contato
├── id
├── tipo
├── valor
└── cliente
```

Relacionamento:

- um cliente pode possuir vários contatos;
- cada contato pertence a um cliente.

Endpoints implementados:

| Método | Endpoint                      | Descrição                           |
| ------ | ----------------------------- | ----------------------------------- |
| GET    | `/aula04-cliente`             | Lista clientes e seus contatos      |
| POST   | `/aula04-cliente`             | Cadastra um cliente                 |
| POST   | `/aula04-contato/{clienteId}` | Cadastra um contato para um cliente |

O `DataLoader` também insere registros iniciais das aulas 3 e 4, facilitando os testes dos endpoints após a inicialização da aplicação.

### Aula 05

Pasta preparada na coleção do Bruno para os próximos conteúdos da disciplina.

## 🧪 Testes de API com Bruno

O diretório `DevSpring-Bruno` contém uma coleção importável no [Bruno](https://www.usebruno.com/), cliente de APIs semelhante ao Postman.

Atualmente, a coleção possui **25 requisições configuradas**:

- 12 requisições GET;
- 9 requisições POST;
- 2 requisições PUT;
- 2 requisições DELETE.

As requisições estão separadas por aula e por recurso, acompanhando a organização do código Java.

Para utilizar:

1. Inicie a aplicação Spring Boot.
2. Abra o Bruno.
3. Selecione **Open Collection**.
4. Escolha a pasta `DevSpring-Bruno`.
5. Abra a aula desejada e execute as requisições.

A aplicação utiliza por padrão:

```text
http://localhost:8080
```

## 🗄️ Banco de dados H2

O projeto utiliza um banco H2 em memória:

```properties
spring.datasource.url=jdbc:h2:mem:meubanco
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.jpa.show-sql=true
```

Console do H2:

```text
http://localhost:8080/h2-console
```

Dados de conexão:

| Campo    | Valor                  |
| -------- | ---------------------- |
| JDBC URL | `jdbc:h2:mem:meubanco` |
| Usuário  | `sa`                   |
| Senha    | vazia                  |

Como o banco funciona em memória, os dados são removidos quando a aplicação é encerrada. O `CommandLineRunner` insere novamente os registros iniciais na próxima execução.

## ▶️ Como executar

### Pré-requisitos

- Java 21
- Git

### Clonar o repositório

```bash
git clone https://github.com/LucasLopesHespanhol/DesenvolvimentoBackendSpring.git
cd DesenvolvimentoBackendSpring
```

### Executar no Windows

```powershell
.\mvnw.cmd spring-boot:run
```

### Executar no Linux ou macOS

```bash
./mvnw spring-boot:run
```

Após a inicialização, a API estará disponível em:

```text
http://localhost:8080
```

## 🎯 Objetivo

Registrar a evolução prática do aprendizado em desenvolvimento backend com Spring, reunindo em um único repositório:

- exemplos desenvolvidos durante as aulas;
- atividades práticas;
- APIs REST;
- persistência de dados;
- relacionamentos entre entidades;
- testes de endpoints;
- evolução da arquitetura da aplicação.

O README será atualizado conforme novos conteúdos forem estudados e implementados.

---

### 👨‍💻 Disciplina

**Desenvolvimento Backend com Spring**

**Professor:** Matheus Leandro Ferreira
