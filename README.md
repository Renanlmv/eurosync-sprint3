# 📦 Eurosync API

---

## Repositório

- **GitHub:** `https://github.com/Renanlmv/eurosync-sprint3.git`

---

## 👥 Equipe
| RM     | Nome            |
|--------|-----------------|
| **RM554924** | Bruno Itikawa   |
| **RM558839** | Carolina Seiko  |
| **RM556761** | Kevin Bueno     |
| **RM555869** | Renan Lopes     |
| **RM558287** | Sophia Barnabé  |


---

## 📖 Sobre o Projeto
Monolítico de API REST para gerenciamento de alunos, professores e turmas, desenvolvido em Java com Spring Boot.

---

## 🎯 Objetivo
Construir uma API REST para gerenciar alunos, professores e turmas, garantindo persistência em banco de dados e documentação interativa dos endpoints.

---

## ⚙️ Funcionalidades
- **CRUD completo** para todas as entidades
- **Persistência** em banco de dados **H2**
- Estruturas distintas para **entrada** (DTOs de request) e **saída** (DTOs de response)
- **Validação** dos dados recebidos
- **Tratamento** adequado de dados inválidos (mensagens de erro claras)
- Rotas versionadas (`/api/v1/...`)
- Documentação interativa com **Swagger/OpenAPI**

---

### 🔗 URL para teste
- **Swagger:** `http:localhost:8080/swagger-ui.html`

---

## Como executar a API no IntelliJ
    1° Baixe ou Clone o projeto em sua máquina
    2° Abra-o no IntelliJ
    3º Verifique se o SDK está configurado para 25:
        - No canto superior esquerdo, no "hambúrguer",
          selecione 'Project Structure'
        - No SDK, selecione 25
        - No canto inferior direito da janela,
          selecione 'Apply'
    4° Selecione a classe MsEurosyncApplication
    5° Clique no botão verde 'Run' no topo da página
       ou ao lado esquerdo do nome da classe

---

## Orientações de Requisições HTTP

## Aluno

---

### GET
    localhost:8080/api/v1/alunos

    localhost:8080/api/v1/alunos/{id}

### POST
    localhost:8080/api/v1/alunos

### PUT
    localhost:8080/api/v1/alunos/{id}

### DELETE
    localhost:8080/api/v1/alunos/{id}



## Professor

---

### GET
    localhost:8080/api/v1/professores

    localhost:8080/api/v1/professores/{id}

### POST
    localhost:8080/api/v1/professores

### PUT
    localhost:8080/api/v1/professores/{id}

### DELETE
    localhost:8080/api/v1/professores/{id}


## Turma

---

### GET
    localhost:8080/api/v1/turmas

    localhost:8080/api/v1/turmas/{id}

    localhost:8080/api/v1/turmas/{id}/professores

### POST
    localhost:8080/api/v1/turmas

    localhost:8080/api/v1/turmas/{turmaId}/professores/{professorId}

### PUT
    localhost:8080/api/v1/turmas/{id}

### DELETE
    localhost:8080/api/v1/turmas/{id}

