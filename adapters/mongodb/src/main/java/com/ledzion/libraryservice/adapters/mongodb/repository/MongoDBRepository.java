package com.ledzion.libraryservice.adapters.mongodb.repository;

import com.ledzion.libraryservice.adapters.mongodb.model.BookEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoDBRepository extends MongoRepository<BookEntity, String> {
}
