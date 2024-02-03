package com.digvijayb.bookstore.controller;

import com.digvijayb.bookstore.model.Book;
import com.digvijayb.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookController {


    private final BookService bookService;


    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        Book saved = bookService.saveBook(book);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") Long id) {
        Book book = bookService.getBook(id);
        return ResponseEntity.of(Optional.ofNullable(book));
    }


    @GetMapping
    public ResponseEntity<Page<Book>> getBooks(@PageableDefault(value = 2, page = 0) Pageable pageable) {
        Page<Book> books = bookService.getBooks(pageable);
        return ResponseEntity.of(Optional.ofNullable(books));
    }


}
