package com.babakalizada.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoLibraryUI {
    private String bookName;
    private String author;
    private String publisher;
    private String genre;
    private String isbn;
    private Integer pages;
    private Double price;
    private Integer quantity;
}
