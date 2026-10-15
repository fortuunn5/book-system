package com.example.book_system.dto;

import com.example.book_system.model.BookLoans;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.List;

public record BookDto(
        @NotNull(message = "Book id must be not null") Long id,

        @NotBlank(message = "Book title must be not empty") String title,

        @NotBlank(message = "Book author must be not empty") String author,

        @Pattern(regexp = "\\d{10}|\\d{13}", message = "Not valid ISBN")
        String isbn,

        Integer publicationYear,

        @Min(value = 0, message = "Total copies >= 0") Integer totalCopies,

        @Min(value = 0, message = "Available copies >= 0") Integer availableCopies,

        List<BookLoans> bookLoansList
) {
}
