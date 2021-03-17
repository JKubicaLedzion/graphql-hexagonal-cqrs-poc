package com.ledzion.libraryservice.delivery.configuration;

import com.ledzion.libraryservice.adapters.graphql.Mutation;
import com.ledzion.libraryservice.adapters.graphql.Query;
import com.ledzion.libraryservice.adapters.mongodb.mappers.BookEntityMapperImpl;
import com.ledzion.libraryservice.adapters.mongodb.repository.BookMongoDBRepositoryImpl;
import com.ledzion.libraryservice.adapters.mongodb.repository.MongoDBRepository;
import com.ledzion.libraryservice.core.service.AddBookCommandHandler;
import com.ledzion.libraryservice.core.service.BookCommandHandlerImpl;
import com.ledzion.libraryservice.core.service.BookQueryHandlerImpl;
import com.ledzion.libraryservice.core.service.DeleteBookCommandHandler;
import com.ledzion.libraryservice.core.service.UpdateBookCommandHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@Import({
        Mutation.class,
        Query.class,
        BookMongoDBRepositoryImpl.class,
        BookCommandHandlerImpl.class,
        BookQueryHandlerImpl.class,
        BookEntityMapperImpl.class,
        AddBookCommandHandler.class,
        DeleteBookCommandHandler.class,
        UpdateBookCommandHandler.class
})
@EnableMongoRepositories(basePackageClasses = {MongoDBRepository.class})
@ComponentScan(basePackageClasses = {MongoDBRepository.class})
public class AppConfig {
}
