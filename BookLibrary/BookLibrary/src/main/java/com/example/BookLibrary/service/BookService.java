package com.example.BookLibrary.service;

import com.example.BookLibrary.model.Author;
import com.example.BookLibrary.model.Book;
import com.example.BookLibrary.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public List<Book> findAllByAuthors(Author author){
       return bookRepository.findAllByAuthors(author);
    }
}
