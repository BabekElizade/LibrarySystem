package com.babakalizada.Controller.impl;

import com.babakalizada.DTO.DtoLibrary;
import com.babakalizada.DTO.DtoLibraryUI;
import com.babakalizada.DTO.priceDTO.PriceUpdateDto;
import com.babakalizada.Entity.Library;

import java.util.List;

public interface RestLibraryContollerImpl {
    public List<DtoLibrary> getAllBooks();
    public DtoLibrary getBookById(Integer id);
    public DtoLibrary updateBookById(Integer id, PriceUpdateDto price);
    public List<DtoLibrary> findBookByName(String bookName);
    public DtoLibrary addBookDB(DtoLibraryUI library);
}
