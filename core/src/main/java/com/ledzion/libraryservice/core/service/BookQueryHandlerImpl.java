package com.ledzion.libraryservice.core.service;

import com.ledzion.libraryservice.api.BookRepository;
import com.ledzion.libraryservice.api.BookServiceQueryHandler;
import com.ledzion.libraryservice.api.model.Book;
import com.ledzion.libraryservice.api.query.GetAllBooksQuery;
import com.ledzion.libraryservice.api.query.GetBookQuery;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class BookQueryHandlerImpl implements BookServiceQueryHandler {

    private BookRepository bookRepository;

    public BookQueryHandlerImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Optional<Book> handle(GetBookQuery getBookQuery) {
        return bookRepository.getBookById(getBookQuery.getId());
    }

    public List<Book> handle(GetAllBooksQuery getAllBooksQuery) {
        return StreamSupport.stream(
                bookRepository.getAllBooks().spliterator(), false)
                .collect(Collectors.toList());
    }
}
