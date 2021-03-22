package com.ledzion.libraryservice.adapters.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.ledzion.libraryservice.adapters.graphql.dto.BookDto;
import com.ledzion.libraryservice.adapters.graphql.mappers.BookDtoMapper;
import com.ledzion.libraryservice.api.BookServiceQueryHandler;
import com.ledzion.libraryservice.api.query.GetAllBooksQuery;
import com.ledzion.libraryservice.api.query.GetBookQuery;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
public class Query implements GraphQLQueryResolver {

    private BookServiceQueryHandler bookServiceQueryHandler;
    private BookDtoMapper bookDtoMapper;

    public BookDto getBookById(String id) {
        log.info("Getting details of book with id {}.", id);
        return bookServiceQueryHandler.handle(new GetBookQuery(id)).isPresent()
                ? bookDtoMapper.bookToBookDto(bookServiceQueryHandler.handle(new GetBookQuery(id)).get())
                : null;
    }

    public List<BookDto> getAllBooks() {
        log.info("Getting details of all books.");
        return bookServiceQueryHandler.handle(new GetAllBooksQuery())
                .stream()
                .map(b -> bookDtoMapper.bookToBookDto(b))
                .collect(Collectors.toList());
    }
}
