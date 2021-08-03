package com.example.BookLibrary.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue
    private Long authorId;
    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    List<Book> books;

}
