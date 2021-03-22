package com.ledzion.libraryservice.core.service;

import com.ledzion.libraryservice.api.BookRepository;
import com.ledzion.libraryservice.api.command.AddBookCommand;
import com.ledzion.libraryservice.api.model.Book;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class AddBookCommandHandler {

    private BookRepository bookRepository;

    public Book handle(AddBookCommand addBookCommand) {
        String uuid = UUID.randomUUID().toString();
        return bookRepository.addBook(
                Book.builder()
                        .id(uuid)
                        .title(addBookCommand.getTitle())
                        .author(addBookCommand.getAuthor())
                        .category(addBookCommand.getCategory())
                        .build());
    }
}
