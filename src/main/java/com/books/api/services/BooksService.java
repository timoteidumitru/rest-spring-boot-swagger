package com.books.api.services;

import com.books.api.exceptions.BookNotFoundException;
import com.books.api.exceptions.BookNotFoundToDeleteException;
import com.books.api.exceptions.DuplicateBookException;
import com.books.api.model.Book;
import com.books.api.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BooksService {
    @Autowired
    private BooksRepository booksRepository;

    public Book addNewBook(Book newBook) throws DuplicateBookException {
        return booksRepository.addBook(newBook);
    }

    public Book getBookByID(int id) throws BookNotFoundException {
        return booksRepository.findBookByID(id);
    }

    public void deleteBookById(int id) throws BookNotFoundToDeleteException {
        booksRepository.deleteBookById(id);
    }
}