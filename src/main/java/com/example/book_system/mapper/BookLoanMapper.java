package com.example.book_system.mapper;

import com.example.book_system.dto.BookLoanDto;
import com.example.book_system.dto.NewBookLoanDto;
import com.example.book_system.model.Book;
import com.example.book_system.model.BookLoan;
import com.example.book_system.model.Reader;

import java.util.ArrayList;
import java.util.List;

public class BookLoanMapper {
    public static BookLoan toEntity(BookLoanDto bookLoanDto) {
        return new BookLoan(
                bookLoanDto.id(),
                new Book(bookLoanDto.bookId()),
                new Reader(bookLoanDto.readerId()),
                bookLoanDto.loanDate(),
                bookLoanDto.dueDate(),
                bookLoanDto.returnDate(),
                bookLoanDto.status()
        );
    }

    public static BookLoanDto toDto(BookLoan bookLoan) {
        return new BookLoanDto(
                bookLoan.getId(),
                bookLoan.getBook().getId(),
                bookLoan.getReader().getId(),
                bookLoan.getLoanDate(),
                bookLoan.getDueDate(),
                bookLoan.getReturnDate(),
                bookLoan.getStatus()
        );
    }

    public static List<BookLoan> toEntity(List<BookLoanDto> bookLoanDtoList) {
        return bookLoanDtoList.stream()
                .map(BookLoanMapper::toEntity)
                .toList();
    }

    public static List<BookLoanDto> toDto(List<BookLoan> bookLoanList) {
        if (bookLoanList == null || bookLoanList.isEmpty()) {
            return new ArrayList<>();
        }
        return bookLoanList.stream()
                .map(BookLoanMapper::toDto)
                .toList();
    }

    public static BookLoan toEntity(NewBookLoanDto newBookLoanDto) {
        return new BookLoan(
                null,
                new Book(newBookLoanDto.bookId()),
                new Reader(newBookLoanDto.readerId()),
                null,
                null,
                null,
                null
        );
    }
}
