# employee-manage
This is a Spring Boot application designed to manage customer information. It provides a RESTful API with capabilities to create, read, update, and delete customer records. The application uses an H2 in-memory database for data persistence and is secured with basic authentication.

# Swagger URL:
http://localhost:8080/swagger-ui/index.html#/

# username : admin passowrd : admin123

Features
CRUD Operations: Manage Employee records with operations to create, read, update, and delete.

Search Functionality: Find Employee by email or phone number.

Data Validation: Ensures data integrity with validation constraints.

RESTful API: Exposes a RESTful interface for client interactions.

Security: Basic authentication to protect endpoints.

Technologies Used
Spring Boot: Framework for building the application.

Spring Data JPA: Manages database interactions.

Hibernate: ORM framework for data persistence.

H2 Database: In-memory database for development and testing.

Spring Security: Provides authentication and authorization.

Project Structure
src\main\java\com\pack\controller

├── CustomerController.java

src\main\java\com\pack\service
├── CustomerService.java

src\main\java\com\pack\dao
├── CustomerRepository.java

src\main\java\com\pack\entity
└── Customer.java

src\main\java\com\pack\
└── GlobalExceptionHandler.java
└── ManageApplication.java
└── PersonalInfo.java
└── SecurityConfig.java
└── WebConfig.java
Installation
To set up and run the project locally:

Clone the repository:

git clone https://github.com/someshnawale22/customer-management.git cd customer-manage

Build the project:

Ensure you have Maven and Java 11 installed. Then, run:

mvn clean install

Run the application:

Use the Spring Boot Maven plugin to start the application:

mvn spring-boot:run

Access the application:

Once the application is running, you can access the API at http://localhost:8080/api/employee.

API Endpoints
GET /api/employee: Retrieve all Employee.

GET /api/employee/{id}: Retrieve a Employee by their ID.

GET /api/employee/search: Search for a Employee by email or phone number.

POST /api/employee: Create a new Employee.

PUT /api/employee/{id}: Update an existing Employee’s information.

DELETE /api/employee/{id}: Delete a employee by their ID.

Usage
Authentication
The API is secured using basic authentication. Use the following credentials for testing:

Username: admin

Password: admin123

Example Request
To create a new customer, send a POST request to /api/customers with JSON data:

Contact
For questions or support, please contact smurmurwar9@gmail.com
