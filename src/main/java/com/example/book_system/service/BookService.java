package com.example.book_system.service;

import com.example.book_system.dto.BookDto;
import com.example.book_system.dto.NewBookDto;

import java.util.List;

public interface BookService {
    BookDto createBook(NewBookDto book);

    BookDto getBookById(Long id);

    List<BookDto> getAllBooks(String title, String author);

    BookDto updateBook(BookDto book);

    void deleteBookById(Long id);

    void takeBook(Long bookId);

    void returnBook(Long bookId);
}
