package com.example.book_system.service;

import com.example.book_system.dto.BookLoanDto;
import com.example.book_system.dto.NewBookLoanDto;
import com.example.book_system.exception.EntityNotFoundException;
import com.example.book_system.mapper.BookLoanMapper;
import com.example.book_system.model.BookLoan;
import com.example.book_system.model.Status;
import com.example.book_system.repository.BookLoanRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookLoanServiceImpl implements BookLoanService {
    private final BookLoanRepository bookLoanRepository;
    private final BookService bookService;

    @Value("${book-system.due-period-weeks}")
    private int duePeriodWeeks;

    //TODO: надо ли разрешить читателю выдавать несколько одинаковых книг?
    @Override
    @Transactional
    public BookLoanDto createBookLoan(NewBookLoanDto bookLoan) {
        BookLoan newBookLoan = BookLoanMapper.toEntity(bookLoan);

        bookService.takeBook(bookLoan.bookId());

        LocalDate now = LocalDate.now();
        newBookLoan.setLoanDate(now);
        newBookLoan.setDueDate(now.plusWeeks(duePeriodWeeks));
        newBookLoan.setStatus(Status.ACTIVE);

        return BookLoanMapper.toDto(bookLoanRepository.save(newBookLoan));
    }

    @Override
    public List<BookLoanDto> getAllBookLoansByReaderId(Long readerId) {
        return BookLoanMapper.toDto(bookLoanRepository.findAllByReaderId(readerId));
    }

    @Override
    public List<BookLoanDto> getAllOverdueBooks() {
        return BookLoanMapper.toDto(bookLoanRepository.findAllByStatus(Status.OVERDUE));
    }

    @Override
    @Transactional
    public BookLoanDto returnBookById(Long id) {
        BookLoan bookLoan = bookLoanRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book loan not found with id: " + id));
        bookLoan.setStatus(Status.RETURNED);
        bookLoan.setReturnDate(LocalDate.now());

        bookService.returnBook(bookLoan.getBook().getId());

        return BookLoanMapper.toDto(bookLoanRepository.save(bookLoan));
    }

    @Override
    @Transactional
    @Scheduled(cron = "0 0 0 * * *", zone = "Europe/Samara")
    public int updateOverdueLoans() {
        return bookLoanRepository.overdueBookLoans();
    }
}
