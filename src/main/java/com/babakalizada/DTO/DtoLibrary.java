package com.babakalizada.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoLibrary {
    @NotEmpty(message = "Book Name field cannot be empty!")
    private String bookName;

    @NotEmpty(message = "Author field cannot be empty!")
    private String author;

    @NotEmpty(message = "Publisher field cannot be empty!")
    private String publisher;

    @NotEmpty(message = "Genre field cannot be empty!")
    private String genre;

    @NotEmpty(message = "ISBN field cannot be empty!")
    private String isbn;

    @NotNull(message = "Pages field cannot be empty!")
    private Integer pages;

    @NotNull(message = "Price field cannot be empty!")
    private Double price;
}
