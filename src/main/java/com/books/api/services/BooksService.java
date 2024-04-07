package com.books.api.services;

import com.books.api.exceptions.BookNotFoundException;
import com.books.api.exceptions.BookNotFoundToDeleteException;
import com.books.api.exceptions.BookNotFoundToUpdateException;
import com.books.api.exceptions.DuplicateBookException;
import com.books.api.model.Book;
import com.books.api.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BooksService {
    @Autowired
    private BooksRepository booksRepository;

    public List<Book> getAllBooks() {
        return booksRepository.getAllBooks();
    }

    public void updateBook(Book updatedBook) throws BookNotFoundToUpdateException {
        int bookId = updatedBook.getId();
        Book existingBook = booksRepository.findBookByID(bookId);
        if (existingBook == null) {
            throw new BookNotFoundToUpdateException(bookId);
        }
        booksRepository.updateBook(updatedBook);
    }

    public void deleteBookById(int id) throws BookNotFoundToDeleteException {
        booksRepository.deleteBookById(id);
    }

    public Book getBookByID(int id) throws BookNotFoundException {
        return booksRepository.findBookByID(id);
    }

    public Book addNewBook(Book newBook) throws DuplicateBookException {
        return booksRepository.addBook(newBook);
    }
}
