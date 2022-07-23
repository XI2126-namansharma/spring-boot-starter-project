package com.example.demo.service.impl;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {

    //List<Book> books1;
    //Map<Integer, Book> books;

    @Autowired
    BookRepository bookRepository;

    public BookServiceImpl() {
       /* books1 = new ArrayList<>();
        books1.add(new Book(100, "How to be a billionaire", "Garvit Gupta"));
        books1.add(new Book(101, "How to be a Writer", "Naman Sharma"));*/

        /*books = new HashMap<>();
        books.put(100, new Book(100, "How to be a billionaire", "Garvit Gupta"));
        books.put(101, new Book(101, "How to be a Writer", "Naman Sharma"));*/
    }

    @Override
    public Book getBook(String bookNo) {
        /*int bookNumber = Integer.parseInt(bookNo);
        for (Book book : books1) {
            if (book.getBookNo() == bookNumber) {
                return book;
            }
        }
        return new Book();*/


        /*int bookNumber = Integer.parseInt(bookNo);
        return books.get(bookNumber);*/

        Book byId = bookRepository.findById(Integer.parseInt(bookNo)).orElse(new Book());
        return byId;
    }

    @Override
    public List<Book> getAllBooks() {
        //return books1;


        //return new ArrayList<>(books.values());

        return bookRepository.findAll();
    }

    @Override
    public Book addBook(Book book) {
        /*books1.add(book);
        return book;*/


        /*books.put(book.getBookNo(), book);
        return book;*/
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        /*for (Book b : books1) {
            if (b.getBookNo() == book.getBookNo()) {
                books1.remove(b);
                break;
            }
        }
        books1.add(book);
        return book;*/


        /*books.put(book.getBookNo(), book);
        return book;*/

        return bookRepository.save(book);
    }

    @Override
    public Book deleteBook(String bookNo) {
        /*Book b;
        int bookNumber = Integer.parseInt(bookNo);
        for (Book book : books1) {
            if (book.getBookNo() == bookNumber) {
                b = book;
                books1.remove(book);
                return b;
            }
        }
        throw new BookNotFoundException("Book not found.");*/

        //return books.remove(Integer.parseInt(bookNo));

        Book b = getBook(bookNo);
        bookRepository.deleteById(Integer.parseInt(bookNo));
        return b;
    }


}
