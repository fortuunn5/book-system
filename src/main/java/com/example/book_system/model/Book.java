package com.example.book_system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Check;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Check(constraints = "available_copies <= total_copies")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false, unique = true, length = 13)
    private String isbn;

    @Column(nullable = false)
    private Integer publicationYear;

    @Column(nullable = false)
    @Check(constraints = "total_copies >= 0")
    private Integer totalCopies;

    @Column(nullable = false)
    @Check(constraints = "available_copies >= 0")
    private Integer availableCopies;

    @OneToMany(mappedBy = "book")
    private List<BookLoan> bookLoanList = new ArrayList<>();

    public Book(Long id) {
        this.id = id;
    }
}
