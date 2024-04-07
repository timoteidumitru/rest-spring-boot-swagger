package com.books.api.exceptions;

public class DuplicateBookException extends Exception {
    public DuplicateBookException(String entity) {
        System.out.printf("A book with the name: '" + entity + "' already exists!");
    }
    public String getMessage(String bookTitle) {
        return "Book with the name: '" + bookTitle + "' already exists!";
    }
}
