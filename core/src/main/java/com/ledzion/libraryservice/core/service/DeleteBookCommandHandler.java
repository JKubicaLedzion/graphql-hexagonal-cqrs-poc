package com.ledzion.libraryservice.core.service;

import com.ledzion.libraryservice.api.BookRepository;
import com.ledzion.libraryservice.api.command.DeleteBookCommand;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteBookCommandHandler {

    private BookRepository bookRepository;

    public boolean handle(DeleteBookCommand deleteBookCommand) {
        return bookRepository.deleteBook(deleteBookCommand.getId());
    }
}
