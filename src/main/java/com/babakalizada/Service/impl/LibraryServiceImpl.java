package com.babakalizada.Service.impl;

import com.babakalizada.DTO.DtoLibrary;

import java.util.List;

public interface LibraryServiceImpl {
    public List<DtoLibrary> getAllBooks();
    public DtoLibrary getBookById(Integer id);
    public DtoLibrary updateBookPriceById(Integer id, Double price);
    public List<DtoLibrary> findBookByName(String bookName);
}
