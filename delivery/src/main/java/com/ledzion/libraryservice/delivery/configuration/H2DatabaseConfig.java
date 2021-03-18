package com.ledzion.libraryservice.delivery.configuration;

import com.ledzion.libraryservice.adapters.h2database.repository.BookH2RepositoryImpl;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Import({
        BookH2RepositoryImpl.class
})
@ComponentScan(basePackages = "com.ledzion.libraryservice.adapters.h2database")
@EnableJpaRepositories(basePackages = "com.ledzion.libraryservice.adapters.h2database")
@EntityScan(basePackages = "com.ledzion.libraryservice.adapters.h2database")
@Configuration
public class H2DatabaseConfig {
}
