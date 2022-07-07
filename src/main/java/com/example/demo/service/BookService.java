package com.example.demo.service;

import com.example.demo.entity.Book;

import java.util.List;

public interface BookService {

    Book getBook(String bookId);

    Book addBook(Book book);

    Book deleteBook(String bookId);

    Book updateBook(Book book);

    List<Book> getAllBooks();
}
