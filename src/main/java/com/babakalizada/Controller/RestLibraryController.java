package com.babakalizada.Controller;

import com.babakalizada.Controller.impl.RestLibraryContollerImpl;
import com.babakalizada.DTO.DtoLibrary;
import com.babakalizada.DTO.priceDTO.PriceUpdateDto;
import com.babakalizada.Service.impl.LibraryServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rest/api/library")
public class RestLibraryController implements RestLibraryContollerImpl {

    private LibraryServiceImpl libraryService;

    public RestLibraryController(LibraryServiceImpl libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping(path = "/all-books")
    @Override
    public List<DtoLibrary> getAllBooks() {
        return libraryService.getAllBooks();
    }
    @GetMapping(path = "/all-books/{id}")
    @Override
    public DtoLibrary getBookById(@PathVariable(name = "id") Integer id) {
        return libraryService.getBookById(id);
    }

    @PostMapping(path = "/update-price/{id}")
    @Override
    public DtoLibrary updateBookById(@PathVariable(name = "id") Integer id, @RequestBody PriceUpdateDto price) {
        return libraryService.updateBookPriceById(id, price.getPrice());
    }
    @GetMapping(path = "/all-books/find-book-by-name/{bookName}")
    @Override
    public List<DtoLibrary> findBookByName(@PathVariable(name = "bookName") String bookName) {
        return libraryService.findBookByName(bookName);
    }
}
