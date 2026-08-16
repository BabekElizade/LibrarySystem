package com.babakalizada.Service;

import com.babakalizada.DTO.DtoLibrary;
import com.babakalizada.DTO.DtoLibraryUI;
import com.babakalizada.Entity.Library;
import com.babakalizada.Repository.LibraryRepository;
import com.babakalizada.Service.impl.LibraryServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryService implements LibraryServiceImpl {

    private LibraryRepository libraryRepository;

    @Autowired
    public LibraryService(LibraryRepository libraryRepository){
        this.libraryRepository = libraryRepository;
    }

    @Override
    public List<DtoLibrary> getAllBooks() {
        List<Library> libraryList = libraryRepository.findAllBooks();
        List<DtoLibrary> dtoLibrary = new ArrayList<>();
        for(Library library : libraryList){
            DtoLibrary dto = new DtoLibrary();
            BeanUtils.copyProperties(library, dto);
            dtoLibrary.add(dto);
        }
        return dtoLibrary;
    }

    @Override
    public DtoLibrary getBookById(Integer id) {
        Library book = libraryRepository.findBookById(id);
        DtoLibrary dto = new DtoLibrary();
        BeanUtils.copyProperties(book, dto);
        return dto;
    }

    @Override
    public DtoLibrary updateBookPriceById(Integer id, Double price) {
        libraryRepository.updateBookPriceById(id, price);
        Library library = libraryRepository.findBookById(id);
        DtoLibrary dto = new DtoLibrary();
        BeanUtils.copyProperties(library, dto);
        return dto;
    }

    @Override
    public List<DtoLibrary> findBookByName(String bookName) {
        List<Library> findBook =  libraryRepository.findBookByName(bookName);
        List<DtoLibrary> dtoLibrary = new ArrayList<>();
        DtoLibrary dto = new DtoLibrary();
        for(Library library : findBook){
            BeanUtils.copyProperties(library, dto);
            dtoLibrary.add(dto);
        }
        return dtoLibrary;
    }

    @Override
    public DtoLibrary addBookDB(DtoLibraryUI library) {
        Library book = new Library();
        DtoLibrary dto = new DtoLibrary();
        BeanUtils.copyProperties(library, book);
        BeanUtils.copyProperties(library, dto);
        libraryRepository.addBookDB(book);
        return dto;
    }


}
