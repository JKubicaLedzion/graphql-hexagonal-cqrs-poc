package com.ledzion.libraryservice.adapters.h2database.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {

    private Long id;

    private String title;

    private String author;

    private CategoryEntity categoryEntity;
}
