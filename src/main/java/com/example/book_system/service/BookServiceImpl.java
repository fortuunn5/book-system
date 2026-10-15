package com.example.book_system.service;

import com.example.book_system.dto.BookDto;
import com.example.book_system.dto.NewBookDto;
import com.example.book_system.exception.EntityNotFoundException;
import com.example.book_system.mapper.BookMapper;
import com.example.book_system.model.Book;
import com.example.book_system.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public BookDto createBook(NewBookDto bookDto) {
        Book book = BookMapper.toEntity(bookDto);
        return BookMapper.toDto(bookRepository.save(book));
    }

    @Override
    public BookDto getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + id));
        return BookMapper.toDto(book);
    }

    @Override
    public List<BookDto> getAllBooks() {
        return BookMapper.toDto(bookRepository.findAll());
    }

    @Override
    public BookDto updateBook(BookDto upBookDto) {
        Book upBook = BookMapper.toEntity(upBookDto);
        return BookMapper.toDto(bookRepository.save(upBook));
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
