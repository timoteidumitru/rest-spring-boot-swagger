package com.books.api.repository;

import com.books.api.exceptions.BookNotFoundToDeleteException;
import com.books.api.exceptions.BookNotFoundToUpdateException;
import com.books.api.exceptions.DuplicateBookException;
import com.books.api.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Repository
public class BooksRepository {
    private final List<Book> dummyBookData = new ArrayList<>() {{
        add(new Book(1, "The Hobbit", "J.R.R. Tolkien's enchanting tale of adventure and heroism in Middle-earth, featuring the reluctant hero Bilbo Bagginess.", "Adventure", 4.8));
        add(new Book(2, "The Catcher in the Rye", "J.D. Salinger's timeless portrayal of teenage angst and rebellion in post-World War II America.", "Coming-of-age", 4.4));
        add(new Book(3, "All Quiet on the Western Front", "Erich Maria Remarque's powerful narrative about the experiences of German soldiers during World War I.", "War", 4.6));
        add(new Book(4, "The Godfather", "Mario Puzo's iconic crime novel following the Corleone family's rise to power in the mafia underworld.", "Crime", 4.7));
        add(new Book(5, "Pride and Prejudice", "Jane Austen's classic romantic comedy revolving around the lives of the Bennet sisters in Regency-era England.", "Love", 4.6));
        add(new Book(6, "Harry Potter and the Sorcerer's Stone", "J.K. Rowling's enchanting tale of a young wizard's journey into the magical world of Hogwarts.", "Fantasy", 4.9));
        add(new Book(7, "The Da Vinci Code", "Dan Brown's gripping thriller featuring symbolist Robert Landon on a quest to unravel ancient mysteries.", "Mystery", 4.3));
        add(new Book(8, "The Power of Habit: Why We Do What We Do in Life and Business", "Charles Higgins's exploration of the science behind habits and how they can be transformed to achieve success.", "Nonfiction", 4.5));
        add(new Book(9, "The Road", "Cormac McCart's post-apocalyptic novel following a father and son's journey through a desolate landscape.", "Post-apocalyptic", 4.5));
        add(new Book(10, "Twilight", "Stephenie Meyer's supernatural romance between a human girl and a vampire, set in the town of Forks, Washington.", "Paranormal romance", 4.2));
    }};

    public List<Book> getAllBooks() {
        return dummyBookData;
    }

    public void updateBook(Book updatedBook) throws BookNotFoundToUpdateException {
        boolean found = false;
        for (int i = 0; i < dummyBookData.size(); i++) {
            Book book = dummyBookData.get(i);
            if (book.getId() == updatedBook.getId()) {
                dummyBookData.set(i, updatedBook);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new BookNotFoundToUpdateException(updatedBook.getId());
        }
    }

    public void deleteBookById(int id) throws BookNotFoundToDeleteException {
        Iterator<Book> iterator = dummyBookData.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getId() == id) {
                iterator.remove();
                found = true;
                break;
            }
        }
        if (!found) {
            throw new BookNotFoundToDeleteException(id);
        }
    }

    public Book findBookByID(int id) {
        Optional<Book> foundBook = dummyBookData.stream()
                .filter(book -> book.getId() == id)
                .findFirst();
        return foundBook.orElse(null);
    }

    public Book addBook(Book newBook) throws DuplicateBookException {
        // Find the maximum ID currently present in the list
        int maxId = dummyBookData.stream()
                .mapToInt(Book::getId)
                .max()
                .orElse(0);

        // Assign a new ID to the new book
        int newId = maxId + 1;
        newBook.setId(newId);

        // Check for duplicate book names
        boolean isDuplicate = dummyBookData.stream()
                .anyMatch(book -> book.getName().equalsIgnoreCase(newBook.getName()));

        if (isDuplicate) {
            throw new DuplicateBookException(newBook.getName());
        } else {
            dummyBookData.add(newBook);
        }
        return newBook;
    }
}
