package com.ledzion.libraryservice.adapters.h2database.mappers;

import com.ledzion.libraryservice.adapters.h2database.model.BookEntity;
import com.ledzion.libraryservice.api.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {CategoryEntityToCategory.class})
public interface BookEntityMapper {

    BookEntityMapper INSTANCE = Mappers.getMapper(BookEntityMapper.class);

    @Mapping(source = "category", target = "categoryEntity")
    BookEntity bookToBookEntity(Book book);

    @Mapping(source = "categoryEntity", target = "category")
    Book bookEntityToBook(BookEntity bookEntity);
}
