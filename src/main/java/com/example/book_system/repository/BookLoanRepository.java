package com.example.book_system.repository;

import com.example.book_system.model.BookLoan;
import com.example.book_system.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookLoanRepository extends JpaRepository<BookLoan, Long> {
    List<BookLoan> findAllByReaderId(Long readerId);

    List<BookLoan> findAllByStatus(Status status);

    @Modifying
    @Query("UPDATE BookLoan bl SET bl.status = 'OVERDUE' WHERE bl.returnDate IS NULL " +
            "AND bl.status='ACTIVE' AND bl.dueDate < CURRENT_DATE")
    int overdueBookLoans();
}
