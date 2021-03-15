package com.ledzion.libraryservice.adapters.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.ledzion.libraryservice.api.BookServiceQueryHandler;
import com.ledzion.libraryservice.api.model.Book;
import com.ledzion.libraryservice.api.query.GetAllBooksQuery;
import com.ledzion.libraryservice.api.query.GetBookQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    private BookServiceQueryHandler bookServiceQueryHandler;

    @Autowired
    public Query(BookServiceQueryHandler bookServiceQueryHandler) {
        this.bookServiceQueryHandler = bookServiceQueryHandler;
    }

    public Book getBookById(Long id) {
        return bookServiceQueryHandler.handle(new GetBookQuery(id)).isPresent()
                ? bookServiceQueryHandler.handle(new GetBookQuery(id)).get()
                : null;
    }

    public List<Book> getAllBooks() {
        return bookServiceQueryHandler.handle(new GetAllBooksQuery());
    }
}
