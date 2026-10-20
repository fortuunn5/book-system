package com.example.book_system.service;

import com.example.book_system.dto.BookLoanDto;
import com.example.book_system.dto.NewBookLoanDto;

import java.util.List;

public interface BookLoanService {
    BookLoanDto createBookLoan(NewBookLoanDto bookLoan);

    List<BookLoanDto> getAllBookLoansByReaderId(Long readerId);

    List<BookLoanDto> getAllOverdueBooks();

    BookLoanDto returnBookById(Long id);

    int updateOverdueLoans();
}
