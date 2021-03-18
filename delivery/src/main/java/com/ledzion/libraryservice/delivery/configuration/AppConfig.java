package com.ledzion.libraryservice.delivery.configuration;

import com.ledzion.libraryservice.adapters.graphql.Mutation;
import com.ledzion.libraryservice.adapters.graphql.Query;
import com.ledzion.libraryservice.adapters.h2database.mappers.BookEntityMapperImpl;
import com.ledzion.libraryservice.adapters.h2database.repository.BookH2RepositoryImpl;
import com.ledzion.libraryservice.adapters.h2database.repository.H2BookRepository;
//import com.ledzion.libraryservice.adapters.mongodb.mappers.BookEntityMapperImpl;
import com.ledzion.libraryservice.adapters.mongodb.repository.BookMongoDBRepositoryImpl;
import com.ledzion.libraryservice.adapters.mongodb.repository.MongoDBRepository;
import com.ledzion.libraryservice.core.service.AddBookCommandHandler;
import com.ledzion.libraryservice.core.service.BookCommandHandlerImpl;
import com.ledzion.libraryservice.core.service.BookQueryHandlerImpl;
import com.ledzion.libraryservice.core.service.DeleteBookCommandHandler;
import com.ledzion.libraryservice.core.service.UpdateBookCommandHandler;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@Import({
        Mutation.class,
        Query.class,
//        BookMongoDBRepositoryImpl.class,
        BookCommandHandlerImpl.class,
        BookQueryHandlerImpl.class,
        BookEntityMapperImpl.class,
        AddBookCommandHandler.class,
        DeleteBookCommandHandler.class,
        UpdateBookCommandHandler.class,
        BookH2RepositoryImpl.class
})
//MongoDB
//@EnableMongoRepositories(basePackageClasses = {MongoDBRepository.class})
//@ComponentScan(basePackageClasses = {MongoDBRepository.class})

//H2Database
@ComponentScan(basePackages = "com.ledzion.libraryservice.adapters.h2database")
@EnableJpaRepositories(basePackages = "com.ledzion.libraryservice.adapters.h2database")
@EntityScan(basePackages = "com.ledzion.libraryservice.adapters.h2database")
public class AppConfig {
}
