package com.ledzion.libraryservice.adapters.mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Document(collection = "books")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {

    @Id
    private String id;

    private String title;

    private String author;

    @Enumerated(EnumType.STRING)
    private CategoryEntity categoryEntity;
}
