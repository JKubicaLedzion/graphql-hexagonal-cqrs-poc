package com.ledzion.libraryservice.adapters.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.ledzion.libraryservice.api.BookServiceCommandHandler;
import com.ledzion.libraryservice.api.command.AddBookCommand;
import com.ledzion.libraryservice.api.command.DeleteBookCommand;
import com.ledzion.libraryservice.api.command.UpdateBookCommand;
import com.ledzion.libraryservice.api.model.Book;
import com.ledzion.libraryservice.api.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    private BookServiceCommandHandler bookServiceCommandHandler;

    @Autowired
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

    public Book updateBook(Long id, String title, String author, Category category){
        return bookServiceCommandHandler.handle(
                UpdateBookCommand.builder()
                        .id(id)
                        .title(title)
                        .author(author)
                        .category(category)
                        .build());
    }

    public boolean deleteBook(Long id) {
        return bookServiceCommandHandler.handle(new DeleteBookCommand(id));
    }
}
