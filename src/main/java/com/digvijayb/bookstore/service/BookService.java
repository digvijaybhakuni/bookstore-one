package com.digvijayb.bookstore.service;

import com.digvijayb.bookstore.model.Book;
import com.digvijayb.bookstore.repo.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;


@Service
@RequiredArgsConstructor
public class BookService {


    private final BookRepository bookRepository;


    @Transactional
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Transactional(readOnly = true)
    public Book getBook(Long id) {
        Book referenceById = bookRepository.getReferenceById(id);
        System.out.println("referenceById = " + referenceById);
        return referenceById;
    }

    public Page<Book> getBooks(Pageable pageable) {
        Page<Book> books = bookRepository.findAll(pageable);
        return books;
    }
}
