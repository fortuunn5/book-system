package com.example.book_system.service;

import com.example.book_system.dto.BookDto;
import com.example.book_system.dto.NewBookDto;

import java.util.List;

public interface BookService {
    BookDto createBook(NewBookDto book);

    BookDto getBookById(Long id);

    List<BookDto> getAllBooks();

    BookDto updateBook(BookDto book);

    void deleteBookById(Long id);
}
