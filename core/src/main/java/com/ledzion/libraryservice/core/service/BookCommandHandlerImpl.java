package com.ledzion.libraryservice.core.service;

import com.ledzion.libraryservice.api.BookRepository;
import com.ledzion.libraryservice.api.BookServiceCommandHandler;
import com.ledzion.libraryservice.api.command.AddBookCommand;
import com.ledzion.libraryservice.api.command.DeleteBookCommand;
import com.ledzion.libraryservice.api.command.UpdateBookCommand;
import com.ledzion.libraryservice.api.model.Book;

public class BookCommandHandlerImpl implements BookServiceCommandHandler {

    private BookRepository bookRepository;

    public BookCommandHandlerImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book handle(AddBookCommand addBookCommand) {
        return bookRepository.addBook(
                Book.builder()
                        .title(addBookCommand.getTitle())
                        .author(addBookCommand.getAuthor())
                        .category(addBookCommand.getCategory())
                        .build());
    }

    public Book handle(UpdateBookCommand updateBookCommand) {
        Book book = bookRepository.getBookById(updateBookCommand.getId()).get();
        book = Book.builder()
                .title(updateBookCommand.getTitle() != null ? updateBookCommand.getTitle() : book.getTitle())
                .author(updateBookCommand.getAuthor() != null ? updateBookCommand.getAuthor() : book.getAuthor())
                .category(updateBookCommand.getCategory() != null ? updateBookCommand.getCategory() : book.getCategory())
                .build();
        bookRepository.addBook(book);
        return book;
    }

    public boolean handle(DeleteBookCommand deleteBookCommand) {
        try {
            bookRepository.deleteBook(deleteBookCommand.getId());
            return true;
        } catch (final Exception e) {
            return false;
        }
    }
}
