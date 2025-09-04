# Student Management Service

A simple Java-based **Student Management Service** using Maven. This project demonstrates a **layered architecture** with DAO and Service layers for managing student records.

## Features

- Add, update, delete, and retrieve students
- Input validation and error handling
- Clean separation of concerns (DAO, Service, Model)

## Technologies

- Java
- Maven

## Project Structure

| Directory | Description |
|-----------|-------------|
| model     | Contains the `Student` entity |
| dao       | Data access layer for CRUD operations |
| service   | Business logic layer |

## Getting Started

Follow these steps to get the project running locally:

1. **Clone the repository**
```bash
git clone https://github.com/busramestan/hibernate.git
cd hibernate
````
2. **Build the project:**
```bash
mvn clean install
````
3. **Run the application:**
    - You can run the main class or integrate with your preferred framework.
## Example Usage

You can use the `StudentService` class to manage students:

```java
StudentService studentService = new StudentService(new StudentDaoImpl());
Student student = new Student("John Doe", "john@example.com");
studentService.saveStudent(student);
