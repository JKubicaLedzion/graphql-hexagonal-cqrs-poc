package com.ledzion.libraryservice.delivery.configuration;

import com.ledzion.libraryservice.adapters.graphql.Mutation;
import com.ledzion.libraryservice.adapters.graphql.Query;
import com.ledzion.libraryservice.adapters.graphql.mappers.BookDtoMapperImpl;
import com.ledzion.libraryservice.adapters.h2database.mappers.BookEntityMapperImpl;
import com.ledzion.libraryservice.core.service.AddBookCommandHandler;
import com.ledzion.libraryservice.core.service.BookCommandHandlerImpl;
import com.ledzion.libraryservice.core.service.BookQueryHandlerImpl;
import com.ledzion.libraryservice.core.service.DeleteBookCommandHandler;
import com.ledzion.libraryservice.core.service.UpdateBookCommandHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        Mutation.class,
        Query.class,
        BookCommandHandlerImpl.class,
        BookQueryHandlerImpl.class,
        BookEntityMapperImpl.class,
        BookDtoMapperImpl.class,
        AddBookCommandHandler.class,
        DeleteBookCommandHandler.class,
        UpdateBookCommandHandler.class,
})
public class AppConfig {
}
