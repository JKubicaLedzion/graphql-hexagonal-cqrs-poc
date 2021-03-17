package com.ledzion.libraryservice.adapters.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.ledzion.libraryservice.api.BookServiceCommandHandler;
import com.ledzion.libraryservice.api.command.AddBookCommand;
import com.ledzion.libraryservice.api.command.DeleteBookCommand;
import com.ledzion.libraryservice.api.command.UpdateBookCommand;
import com.ledzion.libraryservice.api.model.Book;
import com.ledzion.libraryservice.api.model.Category;

public class Mutation implements GraphQLMutationResolver {

    private BookServiceCommandHandler bookServiceCommandHandler;

    public Mutation(BookServiceCommandHandler bookServiceCommandHandler) {
        this.bookServiceCommandHandler = bookServiceCommandHandler;
    }

    public Book addBook(String title, String author, Category category) {
        return bookServiceCommandHandler.handle(
                AddBookCommand.builder()
                        .title(title)
                        .author(author)
                        .category(category)
                        .build());
    }

    public Book updateBook(String id, String title, String author, Category category){
        return bookServiceCommandHandler.handle(
                UpdateBookCommand.builder()
                        .id(id)
                        .title(title)
                        .author(author)
                        .category(category)
                        .build());
    }

    public boolean deleteBook(String id) {
        return bookServiceCommandHandler.handle(new DeleteBookCommand(id));
    }
}
