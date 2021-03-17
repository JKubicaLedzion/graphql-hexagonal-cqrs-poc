package com.ledzion.libraryservice.core.service;

import com.ledzion.libraryservice.api.BookRepository;
import com.ledzion.libraryservice.api.command.AddBookCommand;
import com.ledzion.libraryservice.api.command.UpdateBookCommand;
import com.ledzion.libraryservice.api.model.Book;
import com.ledzion.libraryservice.core.exceptions.BookNotFound;

import java.util.Optional;
import java.util.UUID;

public class UpdateBookCommandHandler {

    private BookRepository bookRepository;

    public UpdateBookCommandHandler(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book handle(UpdateBookCommand updateBookCommand) {
        Optional<Book> book = bookRepository.getBookById(updateBookCommand.getId());
        if(book.isEmpty()) {
            throw new BookNotFound("Book not found.");
        }
        return bookRepository.updateBook(getUpdatedBook(updateBookCommand, book.get()));
    }

    private Book getUpdatedBook(UpdateBookCommand updateBookCommand, Book book) {
        return Book.builder()
                .id(updateBookCommand.getId())
                .title(updateBookCommand.getTitle() != null ? updateBookCommand.getTitle() : book.getTitle())
                .author(updateBookCommand.getAuthor() != null ? updateBookCommand.getAuthor() : book.getAuthor())
                .category(updateBookCommand.getCategory() != null ? updateBookCommand.getCategory() : book.getCategory())
                .build();
    }
}
