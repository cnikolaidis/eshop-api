# eshop-api

A simple e-shop REST API built with Spring Boot 4, Java 21, JPA/Hibernate and MySQL. It exposes CRUD endpoints for products, categories, orders, order items, users and cities, and ships with Swagger UI for interactive documentation.

## Tech Stack

- **Language:** Java 21
- **Framework:** Spring Boot 4.0.3 (Web, Data JPA, Validation)
- **Database:** MySQL 8+
- **ORM:** Hibernate (via Spring Data JPA)
- **API Docs:** springdoc-openapi 2.8.6 (Swagger UI)
- **Build Tool:** Maven

## Project Structure

The codebase follows a layered architecture:

```
src/main/java/com/iekakmi/eshop_api/
├── apiLayer/                  # REST controllers, CORS/Swagger config, exception handler
│   ├── configurations/
│   └── controllers/
├── dataAccessLayer/           # DTOs and services (business logic)
│   ├── models/
│   └── services/
├── domainLayer/               # JPA entities, repositories, enums
│   ├── models/
│   └── repositories/
└── EshopApiApplication.java   # Spring Boot entry point
```

## Domain Model

| Entity            | Description                                          |
| ----------------- | ---------------------------------------------------- |
| `Product`         | Item for sale, belongs to a `ProductCategory`.       |
| `ProductCategory` | Grouping for products.                               |
| `Order`           | A user's purchase, made up of `OrderItem`s.          |
| `OrderItem`       | Line item linking a `Product` to an `Order`.         |
| `User`            | Customer; has an associated `City`.                  |
| `City`            | Lookup table for user locations.                     |

## Prerequisites

- JDK 21
- Maven 3.9+ (or use the wrapper if added)
- A running MySQL 8 instance with a database named `eshop_db`

## Configuration

Database settings live in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/eshop_db
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=validate
```

> Note: `ddl-auto=validate` means the schema must already exist and match the entity mappings. Create the schema before starting the app, or switch this to `update` during development.

Update the username/password to match your local MySQL setup.

## Getting Started

Clone, build, and run:

```bash
# build
mvn clean install

# run
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`.

## API Documentation

Once the application is running, interactive API documentation is available via Swagger UI:

- **Swagger UI:** http://localhost:8080/swagger-ui.html
- **OpenAPI JSON:** http://localhost:8080/v3/api-docs

## REST Endpoints

All resources follow the same CRUD pattern:

| Method   | Path              | Description           |
| -------- | ----------------- | --------------------- |
| `GET`    | `/{resource}`     | List all              |
| `GET`    | `/{resource}/{id}`| Get by id             |
| `POST`   | `/{resource}`     | Create (returns id)   |
| `PUT`    | `/{resource}`     | Update                |
| `DELETE` | `/{resource}/{id}`| Delete                |

Available resources:

- `/products`
- `/product-categories`
- `/orders`
- `/order-items`
- `/users`
- `/cities`

## CORS

CORS is open to all origins and methods (`/**`), configured in `apiLayer/configurations/CorsConfiguration.java`. Tighten this before going to production.

## Testing

```bash
mvn test
```

Test suites are split per layer:

- `ApiLayerTests`
- `BusinessLogicLayerTests`
- `DomainLayerTests`
- `EshopApiApplicationTests`

## Build Artifact

A runnable JAR is produced under `target/` after `mvn package`:

```bash
java -jar target/eshop_api-0.0.1.jar
```
