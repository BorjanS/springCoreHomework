package com.example.BookLibrary.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    private Long bookId;
    private String name;
    private int numPages;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "book_author",
        joinColumns = {@JoinColumn(name = "bookId")},
        inverseJoinColumns = {@JoinColumn(name = "authorId")})
    private List<Author> authors;

}
