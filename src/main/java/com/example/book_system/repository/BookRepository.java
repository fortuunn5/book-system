package com.example.book_system.repository;

import com.example.book_system.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE " +
            "(:title IS NULL OR LOWER(b.title) LIKE LOWER(CONCAT('%', :title, '%')))" +
            "AND (:author IS NULL OR LOWER(b.author) LIKE LOWER(CONCAT('%', :author, '%')))")
    List<Book> findAll(@Param("title") String title, @Param("author") String author);

    @Modifying
    @Query("UPDATE Book b SET b.availableCopies = b.availableCopies - 1 " +
            "WHERE b.id = :id AND b.availableCopies > 0")
    int decrementAvailable(@Param("id") Long id);

    @Modifying
    @Query("UPDATE Book b SET b.availableCopies = b.availableCopies + 1 " +
            "WHERE b.id = :id AND b.availableCopies < b.totalCopies")
    int incrementAvailable(@Param("id") Long id);
}
