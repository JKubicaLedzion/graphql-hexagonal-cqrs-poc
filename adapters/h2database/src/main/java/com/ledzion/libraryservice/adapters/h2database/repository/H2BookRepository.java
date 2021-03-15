package com.ledzion.libraryservice.adapters.h2database.repository;

import com.ledzion.libraryservice.adapters.h2database.model.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface H2BookRepository extends CrudRepository<BookEntity, Long> {
}
