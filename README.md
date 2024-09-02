# Social Media REST API

This project is a REST API for a social media application, built with Spring Boot. It includes functionalities for managing users and their posts.

## Features

- CRUD operations for users and posts
- User authentication and validation
- Exception handling with custom error responses
- Data persistence using Spring Data JPA and MySQL

 **Access the Application:**
    - The application will start on `http://localhost:8080`.

## API Endpoints

### Users

- **Retrieve All Users:**
    - **Endpoint:** `/jpa/users`
    - **Method:** `GET`

- **Retrieve User by ID:**
    - **Endpoint:** `/jpa/users/{id}`
    - **Method:** `GET`

- **Create User:**
    - **Endpoint:** `/jpa/users`
    - **Method:** `POST`
    - **Request Body:**
      ```json
      {
        "name": "Username",
        "email": "username@example.com"
      }
      ```

- **Delete User by ID:**
    - **Endpoint:** `/jpa/users/{id}`
    - **Method:** `DELETE`

- **Retrieve Posts by User ID:**
    - **Endpoint:** `/jpa/users/{id}/posts`
    - **Method:** `GET`

- **Create Post for User:**
    - **Endpoint:** `/jpa/users/{id}/posts`
    - **Method:** `POST`
    - **Request Body:**
      ```json
      {
        "description": "This is a new post",
        "date": "2024-01-01"
      }
      ```

## Exception Handling

The application handles exceptions with custom responses:

- **General Exceptions:** Returns a 500 Internal Server Error with error details.
- **User Not Found Exceptions:** Returns a 404 Not Found with error details.
- **Validation Exceptions:** Returns a 400 Bad Request with validation error details.

## Configuration

The `application.properties` file includes configuration for the application:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/social_media
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

## Database Initialization using Docker

 Launch MySQL using Docker:
    ```
    docker run --detach --env MYSQL_ROOT_PASSWORD=facebook --env MYSQL_USER=social-media-user --env MYSQL_PASSWORD=instagram --env MYSQL_DATABASE=social-media-database --name mysql --publish 3306:3306 mysql:8-oracle
    ```

The application uses an `application.properties` file to configure the MySQL database connection and following dependency. Make sure to set up the database as described in the installation steps (BELOW).

```properties
spring.jpa.defer-datasource-initialization=true
spring.datasource.url=jdbc:mysql://localhost:3306/social-media-database
spring.datasource.username=social-media-user
spring.datasource.password=instagram
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.profiles.active=default
```

```dependency
<dependency>
<groupId>com.mysql</groupId>
<artifactId>mysql-connector-j</artifactId>
<version>8.3.0</version>
</dependency>
```

MySQL Shell Commands

To interact with the MySQL database using MySQL Shell, use the following commands:

```Start MySQL Shell:
mysqlsh
```

```Connect to the database:
\connect todos-user@localhost:3306
```

```Switch to SQL mode:
\sql
```

```Use the todos database:
use todos;
```

```Query the todo table:
select * from to_do;
```

```Exit MySQL Shell:
\quit
```

Docker Commands

To manage the Docker container, use the following commands:

```List running containers:
docker container ls
```

```Stop a container:
docker container stop <container_id>
```
