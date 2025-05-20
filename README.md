# 🎓 Mudemy — Microservice-Based Online Course Platform

Mudemy is a modern, microservice-based online education platform developed using **Java Spring Boot** and **React**. The platform enables users to purchase courses, instructors to publish content, and participants to review and rate courses.

## 📌 Architecture Overview

This application is designed with a microservices architecture and consists of the following core services:

- **API Gateway** — Entry point for all incoming requests
- **Eureka Server (Service Discovery)** — Enables services to dynamically discover and communicate with each other
- **Auth Service** — Handles authentication, registration, and JWT-based token management
- **User Service** — Manages user profiles and related data
- **Course Service** — Manages course creation and listing
- **Order Service** — Manages course purchase and payment operations
- **Notification Service** — Manages asynchronous notifications and Kafka events

## 🛠️ Tech Stack

### 📌 Backend
- Java 17
- Spring Boot 3.x
- Spring Cloud 2024.x
- Spring Cloud Gateway
- Spring Security
- Spring Data JPA
- Hibernate Validator
- JWT (JSON Web Token)
- Feign Client
- Eureka Server
- Apache Kafka
- Redis
- RabbitMQ *(optional)*
- Lombok
- MapStruct
- OpenFeign
- SpringDoc OpenAPI (Swagger UI)
- Testcontainers
- JUnit 5
- Mockito

### 📌 Frontend
- React 19
- React Router
- Redux Toolkit
- Axios
- TailwindCSS
- React Query
- Vite

### 📌 Infrastructure & DevOps
- Docker & Docker Compose
- PostgreSQL
- MySQL
- Prometheus & Grafana
- ELK Stack (Elasticsearch, Logstash, Kibana)
- Zipkin
- Jaeger
- GitHub Actions
- Docker Hub
- Kubernetes

## 📦 Key Microservice Components

- **JWT** for secure authentication and authorization
- **Eureka Server** for service discovery and load balancing
- **Kafka** for event-driven architecture and asynchronous messaging
- **Feign Client** for inter-service communication
- **Redis** for token caching and rate limiting
- **Docker Compose** for infrastructure orchestration
- **OpenAPI (Swagger UI)** for API documentation
- **Prometheus & Grafana** for real-time monitoring
- **Zipkin** for distributed tracing

## 🚀 Getting Started

```bash
# Build all services
./mvnw clean install

# Launch entire infrastructure using Docker Compose
docker-compose up --build