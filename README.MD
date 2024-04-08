# Books API

## Description
This is a RESTful API built with Spring Boot that allows users to perform CRUD (Create, Read, Update, Delete) operations on a collection of books. The API is built following the principles of Level 3 maturity according to Richardson Maturity Model.

## Features
- **Swagger Documentation:** API documentation is provided using Swagger UI.
- **CRUD Operations:** Allows users to perform CRUD operations on a collection of books.
- **Level 3 Maturity:** The API follows Level 3 maturity according to Richardson Maturity Model, providing HATEOAS links for navigating between resources.

## Technologies Used
- Java
- Spring Boot
- Swagger
- HATEOAS

## Endpoints
- `GET /books`: Retrieve all books.
- `GET /books/{id}`: Retrieve a book by ID.
- `POST /books`: Add a new book.
- `PUT /books/{id}`: Update a book by ID.
- `DELETE /books/{id}`: Delete a book by ID.

## How to Use
1. Clone the repository: `git clone https://github.com/timoteidumitru/books-api.git`
2. Navigate to the project directory: `cd books-api`
3. Build the project: `mvn clean install`
4. Run the application: `mvn spring-boot:run`
5. Access the Swagger UI documentation at `http://localhost:8080/api-docs-ui.html`

## Usage Examples
### Retrieve All Books

#### GET /books/all
```json
Response:
[
    {
        "id": 1,
        "title": "The Hobbit",
        "intro": "J.R.R. Tolkien",
        "category": "Fantasy",
        "rating": 7.2
    },
    {
        "id": 2,
        "title": "Pride and Prejudice",
        "intro": "Jane Austen",
        "category": "Romance",
        "rating": 8.1
    }
]
```

POST /books
```
{
    "title": "To Kill a Mockingbird",
    "intro": "Harper Lee",
    "category": "Fiction",
    "rating": 7.2
}
```
```
Response:
{
    "id": 7,
    "title": "To Kill a Mockingbird",
    "intro": "Harper Lee",
    "category": "Fiction",
    "rating": 7.2
}
```

### License
This project is licensed under the MIT License - see the LICENSE file for details.


