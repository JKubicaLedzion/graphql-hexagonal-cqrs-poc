package com.ledzion.libraryservice.api;

import com.ledzion.libraryservice.api.command.AddBookCommand;
import com.ledzion.libraryservice.api.command.DeleteBookCommand;
import com.ledzion.libraryservice.api.command.UpdateBookCommand;
import com.ledzion.libraryservice.api.model.Book;

public interface BookServiceCommandHandler {

    Book handle(AddBookCommand addBookCommand);

    Book handle(UpdateBookCommand updateBookCommand);

    boolean handle(DeleteBookCommand deleteBookCommand);
}
