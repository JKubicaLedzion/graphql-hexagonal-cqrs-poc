package com.ledzion.libraryservice.adapters.graphql.mappers;

import com.ledzion.libraryservice.adapters.graphql.dto.BookDto;
import com.ledzion.libraryservice.api.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookDtoMapper {

    BookDtoMapper INSTANCE = Mappers.getMapper(BookDtoMapper.class);

    BookDto bookToBookDto(Book book);

    Book bookDtoToBook(BookDto bookDto);
}
