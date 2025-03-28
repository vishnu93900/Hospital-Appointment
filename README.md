# Hospital Management System Backend

This project is a foundational backend service developed using Java Spring Boot. It simulates core functionalities of a hospital/provider system, covering essential backend concepts like API design, data persistence, error handling, documentation, logging, containerization, and asynchronous task execution.

## Table of Contents
- Getting Started
- Prerequisites
- Installation
- Running the Application
- API Endpoints
- Error Handling
- [Logging](#logging)
- Containerization
- Asynchronous Task Execution

## Getting Started
These instructions will help you set up and run the project on your local machine for development and testing purposes.

## Prerequisites
- Java 11 or higher
- Maven 3.6.0 or higher
- Docker (for containerization)




**API Endpoints**
Here are some of the core API endpoints:

**Patient Management**

GET /api/patients - Retrieve all patients,
POST /api/patients - Add a new patient
GET /api/patients/{id} - Retrieve a patient by ID
PUT /api/patients/{id} - Update a patient by ID
DELETE /api/patients/{id} - Delete a patient by ID

**Appointment Management**
GET /api/appointments - Retrieve all appointments
POST /api/appointments - Schedule a new appointment
GET /api/appointments/{id} - Retrieve an appointment by ID
PUT /api/appointments/{id} - Update an appointment by ID
DELETE /api/appointments/{id} - Cancel an appointment by ID
Error Handling
The application uses a **global exception handler** to manage errors and provide meaningful responses to the client.

**Logging**
Logging is configured using SLF4J and Logback. Logs are written to both the console and a file located at logs/application.log.

**Asynchronous Task Execution**
Asynchronous tasks are managed using Spring's @Async annotation. This allows for non-blocking operations and improved performance.

**Contributing**
Contributions are welcome! Please fork the repository and create a pull request with your changes.
