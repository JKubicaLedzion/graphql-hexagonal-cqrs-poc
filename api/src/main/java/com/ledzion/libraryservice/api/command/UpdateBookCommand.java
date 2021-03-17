package com.ledzion.libraryservice.api.command;

import com.ledzion.libraryservice.api.model.Category;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateBookCommand {

    private String id;

    private String title;

    private String author;

    private Category category;
}
