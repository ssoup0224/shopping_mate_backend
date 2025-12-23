# Shopping Mate Backend 🛒

Welcome to the **Shopping Mate Backend**, a Spring Boot-based service designed to provide product searching and management capabilities, integrated with the Naver Search API.

---

## 🚀 Teck Stack

- **Language**: Java 17
- **Framework**: Spring Boot 4.0.1
- **Build Tool**: Gradle
- **Database**: MySql (Migration managed by Flyway)
- **Security**: JJWT (JSON Web Token)
- **API Documentation**: SpringDoc OpenAPI / Swagger
- **External Integration**: Naver Search API

---

## ✨ Key Features

- **Naver Product Search**: Integration with Naver Shop Search API to fetch product information.
- **JWT Authentication**: Secure API access using JWT tokens.
- **Database Migrations**: Automated schema management using Flyway.
- **OpenAPI Integration**: Automatically generated API documentation accessible via Swagger UI.

---

## ⚙️ Configuration

The application requires several environment variables to function correctly. These should be placed in a `.env` file in the project root or configured in your environment.

| Variable | Description |
| :--- | :--- |
| `NAVER_URL` | Base URL for Naver Open API (e.g., `https://openapi.naver.com/`) |
| `NAVER_CLIENT_ID` | Your Naver Open API Client ID |
| `NAVER_CLIENT_SECRET` | Your Naver Open API Client Secret |
| `SPRING_DATASOURCE_URL` | MySQL Connection URL |
| `SPRING_DATASOURCE_USERNAME`| MySQL Username |
| `SPRING_DATASOURCE_PASSWORD`| MySQL Password |

---

## 🛠️ Getting Started

### Prerequisites

- Java 17 or higher
- MySQL Database
- Naver Cloud Platform / Developers account for API keys

### Installation & Run

1. **Clone the repository**:
   ```bash
   git clone <repository-url>
   cd shopping_mate_backend
   ```

2. **Set up environment variables**:
   Create a `.env` file in the root directory and add the required configuration variables.

3. **Build the project**:
   ```bash
   ./gradlew build
   ```

4. **Run the application**:
   ```bash
   ./gradlew bootRun
   ```

### API Documentation

Once the application is running, you can access the Swagger UI at:
`http://localhost:8080/swagger-ui.html` (subject to your local port configuration)

---

## 📁 Project Structure

- `src/main/java/com/shopping_mate_backend`: Core application logic.
    - `naver`: Naver Search API integration services and DTOs.
- `src/main/resources`: Configuration files and static assets.
    - `db/migration`: Flyway migration scripts.
- `build.gradle`: Project dependencies and plugins.
