# misoboy-api

> Spring Boot REST API demo with **Keycloak OAuth2** authentication, MyBatis ORM, and H2 in-memory database. Includes Swagger UI.

[![Build Status](https://travis-ci.com/misoboy/misoboy-api.svg?branch=master)](https://travis-ci.com/misoboy/misoboy-api)
[![Coverage Status](https://coveralls.io/repos/github/misoboy/misoboy-api/badge.svg?branch=master)](https://coveralls.io/github/misoboy/misoboy-api?branch=master)
[![Java](https://img.shields.io/badge/Java-8+-orange?logo=java&logoColor=white)](https://java.com)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-2.x-6DB33F?logo=spring&logoColor=white)](https://spring.io/projects/spring-boot)
[![Keycloak](https://img.shields.io/badge/Keycloak-OAuth2-4D4D4D?logo=keycloak&logoColor=white)](https://www.keycloak.org)

## Overview

A demo REST API project showcasing the integration of:

- **Keycloak** — OAuth2/OIDC-based authentication and authorization
- **MyBatis** — SQL mapper framework for database access
- **H2** — In-memory database for local development
- **Swagger UI** — Interactive API documentation

## Tech Stack

| Component | Technology |
|-----------|-----------|
| Framework | Spring Boot 2.x |
| Security | Spring Security + Keycloak |
| ORM | MyBatis |
| Database | H2 (in-memory) |
| Docs | Springfox Swagger |
| CI | Travis CI + CircleCI |

## Getting Started

```bash
git clone https://github.com/misoboy/misoboy-api.git
cd misoboy-api

# Build
./mvnw clean package

# Run
java -jar target/api-0.0.1-SNAPSHOT.jar
```

Open Swagger UI: `http://localhost:8080/swagger-ui.html`

### Run with Maven

```bash
./mvnw spring-boot:run
```

## Testing

```bash
./mvnw clean test
```

## Keycloak Setup

A local Keycloak instance is required for authentication. Configure the realm and client in `application.properties`:

```properties
keycloak.realm=your-realm
keycloak.auth-server-url=http://localhost:8180/auth
keycloak.resource=your-client-id
```

## License

MIT

