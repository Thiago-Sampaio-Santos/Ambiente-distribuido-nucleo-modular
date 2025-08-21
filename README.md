# SAJ-ADS10 - Ambiente Distribuído com Núcleo Modular

## Descrição

Este projeto implementa uma simulação de ambiente distribuído com núcleo modular, comunicação multigrupo e eleição de líder utilizando o algoritmo Bully.

---

## Pré-requisitos

- **Java 21+**
- **Maven 3.9+**
- **Docker** (opcional, para execução em containers)
- **PowerShell (Windows)** para executar múltiplos nós automaticamente

---

## Compilação

```bash
mvn clean package -DskipTests
```

O JAR final estará disponível em:

```
target/saj-distrib-java21-1.0.0.jar
```

---

## Execução Manual dos Nós

Após compilar o projeto (`mvn clean package -DskipTests`), o artefato principal gerado será:

```
target/saj-distrib-java21-1.0.0.jar
```

### Rodar um nó manualmente

```bash
java -jar target/saj-distrib-java21-1.0.0.jar --group=A --nodeId=1
```

Para rodar os nós manualmente, abra múltiplos terminais (um para cada nó) e execute:

### Grupo A
```bash
java -jar target/saj-distrib-java21-1.0.0.jar --group=A --nodeId=1
java -jar target/saj-distrib-java21-1.0.0.jar --group=A --nodeId=2
java -jar target/saj-distrib-java21-1.0.0.jar --group=A --nodeId=3
```

### Grupo B
```bash
java -jar target/saj-distrib-java21-1.0.0.jar --group=B --nodeId=1
java -jar target/saj-distrib-java21-1.0.0.jar --group=B --nodeId=2
java -jar target/saj-distrib-java21-1.0.0.jar --group=B --nodeId=3
```

 Isso iniciará **6 nós** no total, simulando a comunicação distribuída entre dois grupos.

---

## Execução com Docker

O projeto também pode ser executado em containers. Basta usar:

```bash
docker compose up --build
```

Isso criará 6 containers simulando os nós.

---

## Estrutura

```
.
├── docs/                  # Relatórios e documentação técnica
├── scripts/               # Scripts auxiliares (ex: run-nodes.ps1)
├── src/                   # Código-fonte do projeto
├── pom.xml                # Configuração Maven
├── Dockerfile             # Build da imagem Docker
├── docker-compose.yml     # Orquestração dos nós distribuídos
└── README.md              # Este arquivo
```

---

## Funcionalidades

- Comunicação TCP, gRPC e RMI entre nós
- Eleição de líder via Bully Algorithm
- Multicast para descoberta de peers
- Execução multigrupo (A e B)
- Suporte a execução local e via Docker

---

## Autores

Desenvolvido por **Kleberson Sousa, Thiago Sampaio e Hildemar Junior** como parte da disciplina **Sistemas Distribuídos**.

