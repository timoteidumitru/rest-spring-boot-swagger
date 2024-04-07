package com.books.api.exceptions;

public class BookNotFoundToDeleteException extends Exception {
    public BookNotFoundToDeleteException(int id) {
        super("Book with the id: '" + id +"' was not found.");
    }
}
