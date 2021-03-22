package com.ledzion.libraryservice.core.service;

import com.ledzion.libraryservice.api.BookRepository;
import com.ledzion.libraryservice.api.command.UpdateBookCommand;
import com.ledzion.libraryservice.api.exceptions.BookNotFound;
import com.ledzion.libraryservice.api.model.Book;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class UpdateBookCommandHandler {

    private BookRepository bookRepository;

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
