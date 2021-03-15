package com.ledzion.libraryservice.api;

import com.ledzion.libraryservice.api.model.Book;
import com.ledzion.libraryservice.api.query.GetAllBooksQuery;
import com.ledzion.libraryservice.api.query.GetBookQuery;

import java.util.List;
import java.util.Optional;

public interface BookServiceQueryHandler {

    Optional<Book> handle(GetBookQuery getBookQuery);

    List<Book> handle(GetAllBooksQuery getAllBooksQuery);
}
