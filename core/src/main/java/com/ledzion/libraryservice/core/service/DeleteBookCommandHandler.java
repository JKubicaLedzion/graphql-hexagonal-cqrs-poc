package com.ledzion.libraryservice.core.service;

import com.ledzion.libraryservice.api.BookRepository;
import com.ledzion.libraryservice.api.command.AddBookCommand;
import com.ledzion.libraryservice.api.command.DeleteBookCommand;
import com.ledzion.libraryservice.api.model.Book;

import java.util.UUID;

public class DeleteBookCommandHandler {

    private BookRepository bookRepository;

    public DeleteBookCommandHandler(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public boolean handle(DeleteBookCommand deleteBookCommand) {
        return bookRepository.deleteBook(deleteBookCommand.getId());
    }
}
