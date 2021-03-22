package com.ledzion.libraryservice.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Getter
public enum Category {

    THRILLER("THRILLER"),
    HORROR("HORROR"),
    CRIMINAL("CRIMINAL"),
    FANTASY("FANTASY");

    private final String description;

    public static Category getCategory(String description) {
        return Arrays.stream(Category.values())
                .filter(c -> description.equals(c.getDescription()))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("Wrong category provided."));
    }
}
