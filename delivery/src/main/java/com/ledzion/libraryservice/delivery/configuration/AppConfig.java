package com.ledzion.libraryservice.delivery.configuration;

import com.ledzion.libraryservice.adapters.h2database.repository.BookRepositoryImpl;
import com.ledzion.libraryservice.adapters.h2database.repository.H2BookRepository;
import com.ledzion.libraryservice.api.BookRepository;
import com.ledzion.libraryservice.api.BookServiceCommandHandler;
import com.ledzion.libraryservice.api.BookServiceQueryHandler;
import com.ledzion.libraryservice.core.service.BookCommandHandlerImpl;
import com.ledzion.libraryservice.core.service.BookQueryHandlerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
//        BookCommandHandlerImpl.class,
//        BookQueryHandlerImpl.class,
//        BookRepositoryImpl.class
//        H2BookRepository.class
})
public class AppConfig {

//    @Bean
//    BookRepository bookRepository(H2BookRepository h2BookRepository) {
//        return new BookRepositoryImpl(h2BookRepository);
//    }

//    @Bean
//    BookServiceCommandHandler bookServiceCommandHandler(BookRepository bookRepository) {
//        return new BookCommandHandlerImpl(bookRepository);
//    }

    @Bean
    BookServiceQueryHandler bookServiceQueryHandler(BookRepository bookRepository) {
        return new BookQueryHandlerImpl(bookRepository);
    }
}
