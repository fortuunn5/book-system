package com.example.book_system.controller;

import com.example.book_system.dto.BookLoanDto;
import com.example.book_system.dto.NewBookLoanDto;
import com.example.book_system.service.BookLoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/loans")
public class BookLoanController {
    private final BookLoanService bookLoanService;

    @PostMapping
    public ResponseEntity<BookLoanDto> createBookLoan(@RequestBody NewBookLoanDto newBookLoan) {
        return new ResponseEntity<>(bookLoanService.createBookLoan(newBookLoan), HttpStatus.CREATED);
    }

    @GetMapping("/reader/{readerId}")
    public ResponseEntity<List<BookLoanDto>> getAllBookLoansByReaderId(@PathVariable(name = "readerId") Long readerId) {
        return ResponseEntity.ok(bookLoanService.getAllBookLoansByReaderId(readerId));
    }

    @GetMapping("/overdue")
    public ResponseEntity<List<BookLoanDto>> getAllOverdueBooks() {
        return ResponseEntity.ok(bookLoanService.getAllOverdueBooks());
    }

    @PutMapping("/{id}/return")
    public ResponseEntity<BookLoanDto> returnBookById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(bookLoanService.returnBookById(id));
    }
}
