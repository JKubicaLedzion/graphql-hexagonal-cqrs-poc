package com.ledzion.libraryservice.api.command;

import com.ledzion.libraryservice.api.model.Category;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddBookCommand {

    private String title;

    private String author;

    private Category category;
}
