package com.ledzion.libraryservice.api;

import com.ledzion.libraryservice.api.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

    Optional<Book> getBookById(String id);

    List<Book> getAllBooks();

    Book addBook(Book book);

    Book updateBook(Book book);

    boolean deleteBook(String id);
}
