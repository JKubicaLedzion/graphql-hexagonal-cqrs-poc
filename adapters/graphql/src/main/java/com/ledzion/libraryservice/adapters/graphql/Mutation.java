package com.ledzion.libraryservice.adapters.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.ledzion.libraryservice.adapters.graphql.dto.BookDto;
import com.ledzion.libraryservice.adapters.graphql.mappers.BookDtoMapper;
import com.ledzion.libraryservice.api.BookServiceCommandHandler;
import com.ledzion.libraryservice.api.command.AddBookCommand;
import com.ledzion.libraryservice.api.command.DeleteBookCommand;
import com.ledzion.libraryservice.api.command.UpdateBookCommand;
import com.ledzion.libraryservice.api.model.Category;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Mutation implements GraphQLMutationResolver {

    private BookServiceCommandHandler bookServiceCommandHandler;
    private BookDtoMapper bookDtoMapper;

    public BookDto addBook(String title, String author, String category) {
        log.info("Adding new book - title: {}, author: {}, category: {}.", title, author, category);
        return bookDtoMapper.bookToBookDto(
                bookServiceCommandHandler.handle(
                        AddBookCommand.builder()
                                .title(title)
                                .author(author)
                                .category(Category.getCategory(category))
                                .build()));
    }

    public BookDto updateBook(String id, String title, String author, String category){
        log.info("Updating book with id {} - title: {}, author: {}, category: {}.", id, title, author, category);
        return bookDtoMapper.bookToBookDto(
                bookServiceCommandHandler.handle(
                        UpdateBookCommand.builder()
                                .id(id)
                                .title(title)
                                .author(author)
                                .category(Category.getCategory(category))
                                .build()));
    }

    public boolean deleteBook(String id) {
        return bookServiceCommandHandler.handle(new DeleteBookCommand(id));
    }
}
