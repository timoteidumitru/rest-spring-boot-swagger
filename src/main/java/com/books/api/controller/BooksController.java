package com.books.api.controller;

import com.books.api.exceptions.BookNotFoundException;
import com.books.api.exceptions.BookNotFoundToDeleteException;
import com.books.api.exceptions.DuplicateBookException;
import com.books.api.model.Book;
import com.books.api.services.BooksService;
import com.books.api.services.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private BooksService booksService;

    @PostMapping()
    ResponseEntity<Object> addNewBook(@RequestBody Book book) {
        Logger.LogInfo(String.format("%s -> Received POST request.", this.getClass().getSimpleName()));

        try {
            Book newBookAdded = booksService.addNewBook(book);
            return ResponseEntity.status(HttpStatus.CREATED).body(newBookAdded);
        } catch (DuplicateBookException err) {
            Logger.LogError(String.format("%s -> POST request failed: %s", this.getClass().getSimpleName(), err.getMessage()));
            return ResponseEntity.status(HttpStatus.CONFLICT).body(err.getMessage(book.getName()));
        }
    }

    @GetMapping("/{id}")
    ResponseEntity<Object> getBookByID(@PathVariable int id) {
        Logger.LogInfo(String.format("%s -> Received GET request to retrieve book by ID: %d", this.getClass().getSimpleName(), id));

        try {
            Book book = booksService.getBookByID(id);
            if (book != null) {
                return ResponseEntity.status(HttpStatus.OK).body(book);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book with ID " + id + " not found.");
            }
        } catch (BookNotFoundException ex) {
            Logger.LogError(String.format("%s -> GET request failed: %s", this.getClass().getSimpleName(), ex.notFoundMessage(String.valueOf(id))));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.notFoundMessage(String.valueOf(id)));
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Object> deleteBookByID(@PathVariable int id) {
        Logger.LogInfo(String.format("%s -> Received DELETE request to delete book by ID: %d", this.getClass().getSimpleName(), id));

        try {
            booksService.deleteBookById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Book with ID '" + id + "' was successfully deleted.");
        } catch (BookNotFoundToDeleteException ex) {
            Logger.LogError(String.format("%s -> DELETE request failed: %s", this.getClass().getSimpleName(), ex.getMessage()));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

}
