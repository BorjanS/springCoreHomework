package com.example.BookLibrary;

import com.example.BookLibrary.model.Author;
import com.example.BookLibrary.model.Book;
import com.example.BookLibrary.repository.AuthorRepository;
import com.example.BookLibrary.repository.BookRepository;
import com.example.BookLibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootApplication
public class BookLibraryApplication implements CommandLineRunner {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(BookLibraryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		Author author1 = Author.builder().firstName("Dan").lastName("Brown").build();
		Author author2 = Author.builder().firstName("Robert").lastName("Langdon").build();
		Author author3 = Author.builder().firstName("Andrej").lastName("Sapkowski").build();

		Book inferno = Book.builder().name("Inferno").authors(Arrays.asList(author1, author2)).build();
		Book witcher = Book.builder().name("The Witcher").authors(Arrays.asList(author3)).build();

		bookRepository.save(inferno);
		bookRepository.save(witcher);

		List<Book> allBooks = bookService.findAll();
		List<Book> booksFromDanBrown = bookRepository.findAllByAuthors(author1);

		System.out.println(allBooks);
		System.out.println(booksFromDanBrown);

	}
}
