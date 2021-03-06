package com.ledzion.libraryservice.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private String id;

    private String title;

    private String author;

    private Category category;
}
