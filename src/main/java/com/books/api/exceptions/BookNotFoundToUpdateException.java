package com.books.api.exceptions;

import lombok.Getter;

@Getter
public class BookNotFoundToUpdateException extends Exception {
    private final int bookId;

    public BookNotFoundToUpdateException(int bookId) {
        super("Book with ID: '" + bookId + "' was not found.");
        this.bookId = bookId;
    }

}
