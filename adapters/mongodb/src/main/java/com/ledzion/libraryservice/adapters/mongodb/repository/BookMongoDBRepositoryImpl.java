package com.ledzion.libraryservice.adapters.mongodb.repository;

import com.ledzion.libraryservice.adapters.mongodb.exceptions.BookNotFound;
import com.ledzion.libraryservice.adapters.mongodb.mappers.BookEntityMapper;
import com.ledzion.libraryservice.adapters.mongodb.model.BookEntity;
import com.ledzion.libraryservice.api.BookRepository;
import com.ledzion.libraryservice.api.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class BookMongoDBRepositoryImpl implements BookRepository {

    private MongoDBRepository mongoDBRepository;

    private BookEntityMapper bookEntityMapper;

    @Autowired
    public BookMongoDBRepositoryImpl(MongoDBRepository mongoDBRepository, BookEntityMapper bookEntityMapper) {
        this.mongoDBRepository = mongoDBRepository;
        this.bookEntityMapper = bookEntityMapper;
    }

    @Override
    public Optional<Book> getBookById(String id) {
        return mongoDBRepository.findById(id)
                .map(b -> bookEntityMapper.bookEntityToBook(b));
    }

    @Override
    public List<Book> getAllBooks() {
        return StreamSupport.stream(
                mongoDBRepository.findAll().spliterator(), false)
                .map(b -> bookEntityMapper.bookEntityToBook(b))
                .collect(Collectors.toList());
    }

    @Override
    public Book addBook(Book book) {
        return bookEntityMapper.bookEntityToBook(
                mongoDBRepository.save(
                        bookEntityMapper.bookToBookEntity(book)));
    }

    @Override
    public Book updateBook(Book book) {
        if (!mongoDBRepository.existsById(book.getId())) {
            throw new BookNotFound("Book not found.");
        }
        return bookEntityMapper.bookEntityToBook(
                mongoDBRepository.save(
                        bookEntityMapper.bookToBookEntity(book)));
    }

    @Override
    public boolean deleteBook(String id) {
        if (!mongoDBRepository.existsById(id)) {
            return false;
        }
        mongoDBRepository.deleteById(id);
        return true;
    }
}
