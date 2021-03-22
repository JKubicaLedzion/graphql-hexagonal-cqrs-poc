package com.ledzion.libraryservice.adapters.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.ledzion.libraryservice.api.BookServiceQueryHandler;
import com.ledzion.libraryservice.api.model.Book;
import com.ledzion.libraryservice.api.query.GetAllBooksQuery;
import com.ledzion.libraryservice.api.query.GetBookQuery;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@AllArgsConstructor
public class Query implements GraphQLQueryResolver {

    private BookServiceQueryHandler bookServiceQueryHandler;

    public Book getBookById(String id) {
        log.info("Getting details of book with id {}.", id);
        return bookServiceQueryHandler.handle(new GetBookQuery(id)).isPresent()
                ? bookServiceQueryHandler.handle(new GetBookQuery(id)).get()
                : null;
    }

    public List<Book> getAllBooks() {
        log.info("Getting details of all books.");
        return bookServiceQueryHandler.handle(new GetAllBooksQuery());
    }
}
