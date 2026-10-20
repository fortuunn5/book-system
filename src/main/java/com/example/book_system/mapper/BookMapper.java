package com.example.book_system.mapper;

import com.example.book_system.dto.BookDto;
import com.example.book_system.dto.NewBookDto;
import com.example.book_system.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookMapper {
    public static Book toEntity(BookDto bookDto) {
        return new Book(
                bookDto.id(),
                bookDto.title(),
                bookDto.author(),
                bookDto.isbn(),
                bookDto.publicationYear(),
                bookDto.totalCopies(),
                bookDto.availableCopies(),
                BookLoanMapper.toEntity(bookDto.bookLoanList()));
    }

    public static BookDto toDto(Book book) {
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.getPublicationYear(),
                book.getTotalCopies(),
                book.getAvailableCopies(),
                BookLoanMapper.toDto(book.getBookLoanList())
        );
    }

    public static List<Book> toEntity(List<BookDto> bookDtoList) {
        if (bookDtoList == null || bookDtoList.isEmpty()) {
            return new ArrayList<>();
        }
        return bookDtoList.stream()
                .map(BookMapper::toEntity)
                .toList();
    }

    public static List<BookDto> toDto(List<Book> bookList) {
        return bookList.stream()
                .map(BookMapper::toDto)
                .toList();
    }

    public static Book toEntity(NewBookDto newBookDto) {
        return new Book(
                null,
                newBookDto.title(),
                newBookDto.author(),
                newBookDto.isbn(),
                newBookDto.publicationYear(),
                newBookDto.totalCopies(),
                newBookDto.totalCopies(),
                null
        );
    }
}
