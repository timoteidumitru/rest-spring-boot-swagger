package com.books.api.exceptions;

public class BookNotFoundException extends Exception {
    public String notFoundMessage(String bookTitle) {
        return "A book with the name '" + bookTitle + "' doesn't exist in DB!";
    }
}
