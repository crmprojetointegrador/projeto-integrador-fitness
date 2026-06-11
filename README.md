# 💪 Aplicativo Fitness Personalizado - Projeto Integrador

Este é o repositório do **Projeto Integrador** desenvolvido durante o bootcamp da **Generation Brasil**. A aplicação consiste numa API REST backend para um **Aplicativo Fitness Personalizado**, projetado para gerenciar clientes, produtos (suplementos) e oferecer um serviço de cálculo e acompanhamento de Índice de Massa Corporal (IMC), otimizando a experiência do usuário no universo fitness.

---

## 🎯 Objetivo do Projeto

O principal objetivo deste sistema é oferecer uma plataforma integrada para entusiastas do fitness e lojas de suplementos, permitindo o gerenciamento eficiente de um catálogo de produtos e o acompanhamento personalizado da saúde do usuário através do cálculo de IMC. O sistema viabiliza a administração completa de uma loja virtual com informações relevantes para o público-alvo.

---

## 🛠️ Tecnologias Utilizadas

A API foi construída utilizando o ecossistema do **Java** e boas práticas de desenvolvimento:

- **Java 17** (ou superior)
- **Spring Boot 3.x**
    - Spring Data JPA (Camada de persistência de dados)
    - Spring Web (Criação dos Endpoints REST)
    - Spring Validation (Validação de campos com Annotations)
- **MySQL** (Base de dados relacional)
- **Hibernate** (Framework ORM)
- **Insomnia** (Para validação e testes das rotas)

---

## 📐 Estrutura do Projeto (Padrão MVC)

O código está organizado seguindo o padrão de arquitetura em camadas:

- **Model (`.model`):** Definição das entidades do banco de dados (ex: `Cliente`, `Produto`, `Categoria`) com as suas respetivas regras de validação (`@NotNull`, `@Size`, etc).
- **Repository (`.repository`):** Interfaces que estendem o `JpaRepository`, permitindo a comunicação com a base de dados e consultas customizadas.
- **Controller (`.controller`):** Camada de controlo que expõe os endpoints HTTP (`GET`, `POST`, `PUT`, `DELETE`) e faz a ponte com as regras de negócio.

---

## 🛑 Pré-requisitos para Execução

Antes de rodar a aplicação localmente, certifique-se de que possui:

1. **Java JDK 17** ou superior configurado no sistema.
2. Uma ferramenta de base de dados como o **MySQL Workbench** ativa.
3. Uma IDE instalada (Spring Tool Suite - STS, Eclipse, VS Code ou IntelliJ).

---

## 🚀 Como Rodar a Aplicação Localmente
   1. **Clonar este Repositório:**
   ```bash
   git clone https://github.com/crmprojetointegrador/projeto-integrador-fitness.git
   ```

2. **Configurar o Banco de Dados:**
   - No MySQL Workbench, crie uma base de dados com o nome que preferir (ex: `db_fitness_app`).
   - Configure as credenciais de acesso no arquivo `application.properties` localizado em `src/main/resources/`.

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/db_fitness_app?useSSL=false&serverTimezone=UTC
   spring.datasource.username=root
   spring.datasource.password=sua_senha
   ```

3. **Executar a Aplicação:**
   - Importe o projeto na sua IDE como um **Projeto Maven Existente**.
   - Localize a classe principal `FitnessApplication.java` (ou similar) e execute-a como **Spring Boot App**.

## 🤝 Equipe de Desenvolvimento

- **Alanis Santos** - [GitHub](https://github.com/alanis-santos)   [Linkedin](https://www.linkedin.com/in/devalanissantos/)
- **Bruna Mendes** - [GitHub](https://github.com/bruna-dsmendes)   [Linkedin](https://www.linkedin.com/in/devbrunamendes/)
- **Eliane Orlandin** - [GitHub](https://github.com/Eliane-orlandin)   [Linkedin](https://www.linkedin.com/in/elianeorlandindocarmo/)
- **Flame Souza** - [GitHub](https://github.com/PraFlame)   [Linkedin](https://www.linkedin.com/in/souflame/)
- **Patricia Rocha** - [GitHub](https://github.com/patriciarocha1805)   [Linkedin](https://www.linkedin.com/in/patriciarochadev/)

