
# 🏢 Employee Directory REST API

A **Spring Boot** based **REST API** that provides real-time access to an **Employee Directory** system.  
It supports basic **CRUD operations** by connecting to a **SQL Database** via a **layered architecture**: Controller → Service → DAO → Database.

---

## 📋 Table of Contents

- Project Overview
- Architecture
- Tech Stack
- API Endpoints
- Setup and Installation
- Running the Project
- Future Enhancements
- Contributing
- License
- Author

---

## 📖 Project Overview

The goal of this project is to develop a **RESTful Employee Directory API** where:

- Clients can retrieve a list of employees.
- Fetch details of a specific employee by their ID.
- Add a new employee.
- Update employee information.
- Delete an employee from the directory.

In future versions, **authentication** and **authorization** will be added to control access.

---

## 🏛 Architecture

[Client] → [EmployeeRestController] → [EmployeeService] → [EmployeeDAO] → [SQL Database]

- Controller: Manages HTTP requests and responses.
- Service: Handles business logic.
- DAO: Performs database operations.

---

## 🛠 Tech Stack

- Backend Framework: Spring Boot
- Database: MySQL (or any relational DBMS)
- JPA: Hibernate (ORM)
- Build Tool: Maven
- Testing: Postman, Swagger (optional)
- Tools: Spring Initializr, IntelliJ IDEA, Visual Studio Code

---

## 📡 API Endpoints

| HTTP Method | Endpoint | Description |
|:-----------:|:--------:|:------------|
| GET | /api/employees | Retrieve all employees |
| GET | /api/employees/{id} | Retrieve a single employee by ID |
| POST | /api/employees | Create a new employee |
| PUT | /api/employees/{id} | Update an existing employee |
| DELETE | /api/employees/{id} | Delete an employee |

Example JSON for POST/PUT requests:

{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com"
}

---

## ⚙️ Setup and Installation

### Prerequisites

- Java 17+ installed
- Maven installed
- MySQL or any SQL-compatible database installed
- Postman (optional for testing)

### 1. Clone the Repository

git clone https://github.com/AbWaris7/Employee-Directory-REST-API
cd employee-directory-api

### 2. Configure Database

Update your src/main/resources/application.properties file:

spring.datasource.url=jdbc:mysql://localhost:3306/employee_directory
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
server.port=8080

### 3. Build the Project

./mvnw clean install

### 4. Run the Application

./mvnw spring-boot:run

The application will start on:
http://localhost:8080

---

## 🚀 Running the Project

After starting the server:

- Access all employees: GET http://localhost:8080/api/employees
- Access single employee: GET http://localhost:8080/api/employees/{id}
- Add a new employee: POST http://localhost:8080/api/employees
- Update employee: PUT http://localhost:8080/api/employees/{id}
- Delete employee: DELETE http://localhost:8080/api/employees/{id}

Test APIs using tools like Postman or cURL.

---

## 📈 Future Enhancements

- Implement authentication and authorization using Spring Security.
- Add role-based access control (admin vs user).
- Integrate Swagger/OpenAPI documentation.
- Add pagination, sorting, and filtering.
- Implement unit and integration testing (JUnit/Mockito).
- Dockerize the application for containerization.
- CI/CD integration using GitHub Actions.

---

## 🤝 Contributing

Contributions are welcome!

1. Fork the repository
2. Create a feature branch (git checkout -b feature-name)
3. Commit your changes (git commit -m 'Add some feature')
4. Push to the branch (git push origin feature-name)
5. Open a Pull Request

---

## 📄 License

Distributed under the MIT License.

---

## 👨‍💻 Author: Abdul Waris Khan


- GitHub: https://github.com/AbWaris7/Employee-Directory-REST-API

---

# 🎯 Final Notes

- Clean project structure
- RESTful design principles
- Real-time data access
- Ready for scaling and future improvements
