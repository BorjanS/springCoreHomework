package com.example.BookLibrary.repository;

import com.example.BookLibrary.model.Author;
import com.example.BookLibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAll();
    List<Book> findAllByAuthors(Author author);
}
