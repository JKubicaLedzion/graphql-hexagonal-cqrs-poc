package com.ledzion.libraryservice.adapters.h2database.repository;

import com.ledzion.libraryservice.adapters.h2database.model.BookEntity;
import com.ledzion.libraryservice.api.BookRepository;
import com.ledzion.libraryservice.api.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepositoryImpl implements BookRepository {

    private H2BookRepository h2BookRepository;

    public BookRepositoryImpl(H2BookRepository h2BookRepository) {
        this.h2BookRepository = h2BookRepository;
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        BookEntity entity = h2BookRepository.findById(id).get();
        return Optional.of(Book.builder().title(entity.getTitle()).build());
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
        BookEntity entity = h2BookRepository.save(BookEntity.builder().title(book.getTitle()).build());
        return Book.builder().title(entity.getTitle()).build();
    }

    @Override
    public Book updateBook(Book book) {
        BookEntity entity = h2BookRepository.save(BookEntity.builder().title(book.getTitle()).build());
        return Book.builder().title(entity.getTitle()).build();
    }

    @Override
    public boolean deleteBook(Long id) {
        h2BookRepository.deleteById(id);
        return true;
    }
}
