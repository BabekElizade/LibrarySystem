package com.babakalizada.Repository;

import com.babakalizada.DTO.DtoLibrary;
import com.babakalizada.DTO.DtoLibraryUI;
import com.babakalizada.Entity.Library;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer> {

    @Query(value = "select * from library", nativeQuery = true)
    List<Library> findAllBooks();

    @Query(value = "select * from library where id = :id", nativeQuery = true)
    Library findBookById(Integer id);

    @Modifying
    @Transactional
    @Query(value = "update library set price = :price where id = :id", nativeQuery = true)
    void updateBookPriceById(@Param("id") Integer id, @Param("price") Double price);

    @Query(value = "select * from library where bookname = :bookName", nativeQuery = true)
    List<Library> findBookByName(@Param("bookName") String bookName);

    @Modifying
    @Transactional
    @Query(value = "insert into library (genre, isbn, author, bookname, price, publisher, quantity, pages) " +
            "values (:#{#library.genre}, :#{#library.isbn}, :#{#library.author}, :#{#library.bookName}, " +
            ":#{#library.price}, :#{#library.publisher}, :#{#library.quantity}, :#{#library.pages})",
            nativeQuery = true)
    void addBookDB(@Param("library") Library library);
}
