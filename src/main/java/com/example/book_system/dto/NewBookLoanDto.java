package com.example.book_system.dto;

import jakarta.validation.constraints.NotNull;

public record NewBookLoanDto(
        @NotNull Long bookId,
        @NotNull Long readerId
) {
}
