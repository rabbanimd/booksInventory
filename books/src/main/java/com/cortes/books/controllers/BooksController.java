package com.cortes.books.controllers;

import com.cortes.books.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/books")
public class BooksController {
    @Autowired
    private BooksService booksService;

    @GetMapping("/")
    public ResponseEntity getBooksList(@RequestParam(required = false, defaultValue = "0")int pageNo,
                                       @RequestParam(required = false, defaultValue = "10") int pageSize) {
        return new ResponseEntity(booksService.getBooksList(pageNo, pageSize), HttpStatus.OK);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity getBookById(@PathVariable("id") Long id) {
        return new ResponseEntity(booksService.getBookById(id), HttpStatus.OK);
    }
    @GetMapping("/author/{author_name}")
    public ResponseEntity getBootAuthorName(@PathVariable("author_name") String authorName, @RequestParam(required = false, defaultValue = "0")int pageNo,
                                            @RequestParam(required = false, defaultValue = "10") int pageSize) {
        return new ResponseEntity(booksService.getBooksByAuthor(pageNo, pageSize, authorName),
                HttpStatus.OK);
    }
    @GetMapping("/book/{book_name}")
    public ResponseEntity getBookByBookName(@PathVariable("book_name") String bookName, @RequestParam(required = false, defaultValue = "0")int pageNo,
                                            @RequestParam(required = false, defaultValue = "10") int pageSize) {
        System.out.println("bookName : "+bookName);
        return new ResponseEntity(booksService.getBooksByName(pageNo, pageSize, bookName),
                HttpStatus.OK);
    }
}
