package com.ledzion.libraryservice.adapters.h2database.repository;

import com.ledzion.libraryservice.adapters.h2database.exceptions.BookNotFound;
import com.ledzion.libraryservice.adapters.h2database.mappers.BookEntityMapper;
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
    private BookEntityMapper bookEntityMapper;

    @Autowired
    public BookH2RepositoryImpl(H2BookRepository h2BookRepository, BookEntityMapper bookEntityMapper) {
        this.h2BookRepository = h2BookRepository;
        this.bookEntityMapper = bookEntityMapper;
    }

    @Override
    public Optional<Book> getBookById(String id) {
        return h2BookRepository.findById(id)
                .map(b -> bookEntityMapper.bookEntityToBook(b));
    }

    @Override
    public List<Book> getAllBooks() {
        return StreamSupport.stream(
                h2BookRepository.findAll().spliterator(), false)
                .map(b -> bookEntityMapper.bookEntityToBook(b))
                .collect(Collectors.toList());
    }

    @Override
    public Book addBook(Book book) {
        return bookEntityMapper.bookEntityToBook(
                h2BookRepository.save(
                        bookEntityMapper.bookToBookEntity(book)));
    }

    @Override
    public Book updateBook(Book book) {
        if (!h2BookRepository.existsById(book.getId())) {
            throw new BookNotFound("Book not found.");
        }
        return bookEntityMapper.bookEntityToBook(
                h2BookRepository.save(
                        bookEntityMapper.bookToBookEntity(book)));
    }

    @Override
    public boolean deleteBook(String id) {
        if (!h2BookRepository.existsById(id)) {
            return false;
        }
        h2BookRepository.deleteById(id);
        return true;
    }
}
