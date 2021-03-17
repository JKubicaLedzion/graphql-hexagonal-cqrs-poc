package com.ledzion.libraryservice.adapters.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.ledzion.libraryservice.api.BookServiceQueryHandler;
import com.ledzion.libraryservice.api.model.Book;
import com.ledzion.libraryservice.api.query.GetAllBooksQuery;
import com.ledzion.libraryservice.api.query.GetBookQuery;

import java.util.List;

public class Query implements GraphQLQueryResolver {

    private BookServiceQueryHandler bookServiceQueryHandler;

    public Query(BookServiceQueryHandler bookServiceQueryHandler) {
        this.bookServiceQueryHandler = bookServiceQueryHandler;
    }

    public Book getBookById(String id) {
        return bookServiceQueryHandler.handle(new GetBookQuery(id)).isPresent()
                ? bookServiceQueryHandler.handle(new GetBookQuery(id)).get()
                : null;
    }

    public List<Book> getAllBooks() {
        return bookServiceQueryHandler.handle(new GetAllBooksQuery());
    }
}
