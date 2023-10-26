# Jakarta EE Project

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Project Structure](#project-structure)
- [Technologies](#technologies)
- [Getting Started](#getting-started)
- [Usage](#usage)

## Introduction

Welcome to the Jakarta EE Project! This project is a Jakarta EE-based application that demonstrates the use of Data Access Object (DAO) classes to manage various entities in a database.

## Features

- Efficient data management using Jakarta Persistence API (JPA).
- User and role management for access control.
- Management of departments, equipment, workers, and breakdowns.
- Demonstrates best practices for Jakarta EE application development.

## Project Structure

The project is organized into several DAO classes, each responsible for managing a specific entity. Here's an overview:

- **WorkerDao**: Manages workers, including adding, updating, and deleting worker entities.
- **UserDao**: Handles user management, including saving users, updating roles, and retrieving users.
- **RoleDao**: Manages roles and includes a method to find roles by name.
- **DepartmentDao**: Manages department entities and provides methods for retrieval.
- **EquipmentsDao**: Manages equipment entities, including CRUD operations.
- **BreakDownDao**: Handles breakdown entities and retrieval.

## Technologies

- **Jakarta EE**: The project is built using Jakarta EE, an industry-standard for building enterprise-level Java applications.
- **Java Persistence API (JPA)**: JPA is used for object-relational mapping (ORM) and database interactions.
- **EntityManager**: Used for managing entities in the database.
 **Persistence Configuration**: Database configuration is defined in `persistence.xml`.

## Getting Started

To get started with this project, follow these steps:

1. Clone this repository to your local machine.
2. Review and update the database connection details in `persistence.xml` if needed.
3. Build and deploy the project on a Jakarta EE-compatible server.
4. Access the application through the appropriate URL.
