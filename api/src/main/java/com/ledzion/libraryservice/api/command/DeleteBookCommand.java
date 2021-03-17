package com.ledzion.libraryservice.api.command;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeleteBookCommand {

    private String id;
}
