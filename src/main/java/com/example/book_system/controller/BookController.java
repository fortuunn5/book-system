package com.example.book_system.controller;

import com.example.book_system.dto.BookDto;
import com.example.book_system.dto.NewBookDto;
import com.example.book_system.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BookDto> createBook(@Valid @RequestBody NewBookDto newBook) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(bookService.createBook(newBook));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable(name = "id") Long id) {
        return ResponseEntity
                .ok(bookService.getBookById(id));
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return ResponseEntity
                .ok(bookService.getAllBooks());
    }

    @PutMapping
    public ResponseEntity<BookDto> updateBook(@Valid @RequestBody BookDto book) {
        return ResponseEntity
                .ok(bookService.updateBook(book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable(name = "id") Long id) {
        bookService.deleteBookById(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
