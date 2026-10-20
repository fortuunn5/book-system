package com.example.book_system.dto;

import com.example.book_system.model.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record BookLoanDto(
        @NotNull Long id,
        @NotNull Long bookId,
        @NotNull Long readerId,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
        @NotNull
        LocalDate loanDate,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
        @NotNull
        LocalDate dueDate,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
        LocalDate returnDate,

        @NotNull Status status
) {
}
