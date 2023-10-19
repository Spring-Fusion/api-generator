
---

# Api Generator

[![Build Status](https://travis-ci.org/yourusername/projectname.svg?branch=master)](https://travis-ci.org/yourusername/projectname)

## Description
 
This Java-based API allows you to easily generate Spring classes with pre-built templates, making it simple to kickstart your development process. Whether you're a beginner or an experienced developer, this tool will save you time and effort in setting up a new project.

### Key Features:
🔷 Custom Entity Creation: Define your entities with custom fields, data types, sizes, and more, all through a simple request.

🔷 Automatic Generation of Controller, Repository, and Entity: Based on the provided specifications, the API Generator automatically creates the necessary classes, saving hours of manual coding.

🔷 Flexible Customization: Choose the entity name, endpoint name, package, modifier, and more, ensuring that the generated code adapts to your specific needs.

🔷 Support for Popular Technologies: Our project is built using Java, Spring Boot, Maven, PostgreSQL, Lombok, and integration with Swagger, so you can focus on what really matters: developing amazing features for your APIs.

🔷 Boost Productivity: With the API Generator, you can accelerate API development and reduce human errors, allowing your team to focus on creating value for your customers.

## Table of Contents

- [Getting Started](#getting-started)
- [Usage](#usage)
- [Contributing](#contributing)
- [Technologies Used](#technologies-used)
- [License](#license)

## Getting Started 

These instructions will help you get the project up and running on your local machine.

### Prerequisites

- Java 8 or higher
- Maven
- Git 

### Installation - Instalação

1. Clone the repository

```shell
git clone https://github.com/gmcdr/api-generator.git
```

2. Navigate to the project directory

```shell
cd api-generator
```

3. Build the project

```shell
mvn clean install
```

4. Run the project 

```shell
mvn spring-boot:run
```

## Usage 

Certainly, here's the README content in Markdown format:

```markdown
# API Endpoints README

This document provides information about the API endpoints for a system generating and managing entities. These endpoints allow you to save and manipulate entity definitions, generate projects, publish projects, and create entities within the system.

## Table of Contents

- [1. Save Entity Definition](#1-save-entity-definition)
- [2. Generate Project](#2-generate-project)
- [3. Publish Project](#3-publish-project)
- [4. Create Entity](#4-create-entity)

## 1. Save Entity Definition

This endpoint allows you to save an entity definition with a specified name, attributes, and metadata.

**Endpoint:** `POST http://localhost:8080/entity/saveEntity`

**Request Body:**
```json
{
    "entity": {
        "name": {
            "type": "string",
            "size": "255"
        },
        "age": {
            "type": "int",
            "size": "255"
        },
        "email": {
            "type": "string",
            "size": "255"
        },
        "salary": {
            "type": "double",
            "size": "255"
        },
        "children": {
            "type": "boolean"
        },
        "event": {
            "type": "localDateTime"
        }
    },
    "entityName": "Employee",
    "endPointName": "employee",
    "package": "com.appfusion.apigenerator.builder",
    "modifier": "public",
    "clientID": "test"
}
```

- `entity`: An object describing the entity's attributes.
- `entityName`: The name of the entity.
- `endPointName`: The name for the endpoint.
- `package`: The package name.
- `modifier`: The access modifier for the entity.
- `clientID`: The client ID associated with this entity.

## 2. Generate Project

This endpoint is used to generate a project based on the provided specifications.

**Endpoint:** `GET http://localhost:8080/entity/generateProject/test`

- `test` in the endpoint is used to identify the project to generate.

## 3. Create Entity

This endpoint is used to create an entity with a specified ID.

**Endpoint:** `POST http://localhost:8080/entity/createEntity/1204`

- `1204` in the endpoint is the entity ID to be created.
```

## 4. Publish Project

This endpoint allows you to publish a project.

**Endpoint:** `GET http://localhost:8080/entity/publishProject/test`

- `test` in the endpoint is used to identify the project to publish.

## Contributing

We welcome contributions from the community! If you'd like to contribute to this project, please follow these guidelines:

1. Fork the repository - Faça um fork do repositório
2. Create a new branch - Crie um novo branch
3. Make your changes - Faça suas alterações
4. Test your changes - Teste suas alterações
5. Submit a pull request - Envie um pull request

For major changes, please open an issue first to discuss what you would like to change.

## Technologies Used - Tecnologias Usadas

- Java
- Spring Boot
- Maven
- PostgreSQL
- Lombok
- Swagger

[Buy Me a Coffee](https://www.buymeacoffee.com/gabrielreib)
