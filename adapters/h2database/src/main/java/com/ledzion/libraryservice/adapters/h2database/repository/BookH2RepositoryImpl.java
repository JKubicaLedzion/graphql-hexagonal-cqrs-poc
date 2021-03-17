package com.ledzion.libraryservice.adapters.h2database.repository;

import com.ledzion.libraryservice.adapters.h2database.model.BookEntity;
import com.ledzion.libraryservice.api.BookRepository;
import com.ledzion.libraryservice.api.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class BookH2RepositoryImpl implements BookRepository {

    private H2BookRepository h2BookRepository;

    @Autowired
    public BookH2RepositoryImpl(H2BookRepository h2BookRepository) {
        this.h2BookRepository = h2BookRepository;
    }

    @Override
    public Optional<Book> getBookById(String id) {
        BookEntity entity = h2BookRepository.findById(id).get();
        return Optional.of(
                Book.builder()
                        .id(entity.getId())
                        .title(entity.getTitle())
                        .author(entity.getAuthor())
                        .build());
    }

    @Override
    public List<Book> getAllBooks() {
//        return StreamSupport.stream(
//                h2BookRepository.findAll().spliterator(), false)
//                .collect(Collectors.toList());
        return List.of();
    }

    @Override
    public Book addBook(Book book) {
        BookEntity entity = h2BookRepository.save(
                BookEntity.builder()
                        .title(book.getTitle())
                        .author(book.getAuthor())
                        .build());
        return book;
    }

    @Override
    public Book updateBook(Book book) {
        BookEntity entity = h2BookRepository.save(
                BookEntity.builder()
                        .title(book.getTitle())
                        .author(book.getAuthor())
                        .build());
        return book;
    }

    @Override
    public boolean deleteBook(String id) {
        h2BookRepository.deleteById(id);
        return true;
    }
}
