# Todo App

A full-stack Todo application built with Spring Boot, PostgreSQL, Spring Security, JWT Authentication, and a vanilla HTML/CSS/JavaScript frontend.

## Features

### Authentication

* User Registration
* User Login
* JWT-based Authentication
* Secure Password Storage
* User Logout

### Todo Management

* Create Todo
* View All Todos
* View Single Todo
* Update Todo
* Delete Todo

### Security

* Protected API Endpoints
* User-specific Todo Access
* Password Encryption
* JWT Authorization

## Tech Stack

### Frontend

* HTML
* CSS
* JavaScript

### Backend

* Java
* Spring Boot
* Spring Security
* JWT Authentication
* Spring Data JPA
* Hibernate

### Database

* PostgreSQL

### Tools

* Git
* GitHub
* Postman

## Project Structure

```text
todo-app
│
├── frontend
│   ├── pages
│   ├── css
│   ├── js
│   └── assets
│
├── backend
│   ├── controller
│   ├── service
│   ├── repository
│   ├── model
│   ├── config
│
└── database
```

## Database Design

### User

| Field    | Type   |
| -------- | ------ |
| id       | Long   |
| username | String |
| email    | String |
| password | String |

### Todo

| Field       | Type      |
| ----------- | --------- |
| id          | Long      |
| title       | String    |
| description | String    |
| createdAt   | Timestamp |
| updatedAt   | Timestamp |
| userId      | Long      |

## API Endpoints

### Authentication

| Method | Endpoint           | Description   |
| ------ | ------------------ | ------------- |
| POST   | /api/auth/register | Register user |
| POST   | /api/auth/login    | Login user    |

### Todos

| Method | Endpoint        | Description    |
| ------ | --------------- | -------------- |
| POST   | /api/todos      | Create todo    |
| GET    | /api/todos      | Get all todos  |
| GET    | /api/todos/{id} | Get todo by id |
| PUT    | /api/todos/{id} | Update todo    |
| DELETE | /api/todos/{id} | Delete todo    |

## Validation Rules

### User

* Name is required
* Email must be valid
* Email must be unique
* Password is required

### Todo

* Title is required
* Description is optional

## Learning Objectives

This project demonstrates:

* REST API development
* Spring Boot fundamentals
* Spring Security
* JWT Authentication
* Database integration with PostgreSQL
* JPA/Hibernate ORM
* Full CRUD operations
* Frontend and backend integration
* API testing with Postman
* Version control with Git and GitHub

## Future Improvements

* Todo status tracking
* Todo priorities
* Due dates
* Search functionality
* Filtering
* Sorting
* Pagination
* User profile management
* Refresh tokens
* Dark mode

## Getting Started

### Prerequisites

* Java
* Maven
* PostgreSQL
* Git

### Installation

1. Clone the repository

```bash
git clone <repository-url>
```

2. Configure PostgreSQL database

3. Update application properties

4. Run the Spring Boot application

```bash
mvn spring-boot:run
```

5. Open the frontend in your browser

## Author

Built as a learning project to practice full-stack development with Spring Boot and modern authentication.
