package com.ledzion.libraryservice.core.service;

import com.ledzion.libraryservice.api.BookRepository;
import com.ledzion.libraryservice.api.command.AddBookCommand;
import com.ledzion.libraryservice.api.model.Book;

import java.util.UUID;

public class AddBookCommandHandler {

    private BookRepository bookRepository;

    public AddBookCommandHandler(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

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
