package com.ledzion.libraryservice.core.service;

import com.ledzion.libraryservice.api.BookServiceCommandHandler;
import com.ledzion.libraryservice.api.command.AddBookCommand;
import com.ledzion.libraryservice.api.command.DeleteBookCommand;
import com.ledzion.libraryservice.api.command.UpdateBookCommand;
import com.ledzion.libraryservice.api.model.Book;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BookCommandHandlerImpl implements BookServiceCommandHandler {

    private AddBookCommandHandler addBookCommandHandler;
    private UpdateBookCommandHandler updateBookCommandHandler;
    private DeleteBookCommandHandler deleteBookCommandHandler;

    public Book handle(AddBookCommand addBookCommand) {
        return addBookCommandHandler.handle(addBookCommand);
    }

    public Book handle(UpdateBookCommand updateBookCommand) {
        return updateBookCommandHandler.handle(updateBookCommand);
    }

    public boolean handle(DeleteBookCommand deleteBookCommand) {
        return deleteBookCommandHandler.handle(deleteBookCommand);
    }
}
