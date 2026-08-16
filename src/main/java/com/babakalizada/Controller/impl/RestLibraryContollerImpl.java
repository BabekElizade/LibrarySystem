package com.babakalizada.Controller.impl;

import com.babakalizada.DTO.DtoLibrary;
import com.babakalizada.DTO.priceDTO.PriceUpdateDto;

import java.util.List;

public interface RestLibraryContollerImpl {
    public List<DtoLibrary> getAllBooks();
    public DtoLibrary getBookById(Integer id);
    public DtoLibrary updateBookById(Integer id, PriceUpdateDto price);
    public List<DtoLibrary> findBookByName(String bookName);
}
