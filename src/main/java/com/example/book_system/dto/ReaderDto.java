package com.example.book_system.dto;

import com.example.book_system.model.BookLoans;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;
import java.util.List;

public record ReaderDto(
        Long id,

        @NotBlank(message = "Reader name must be not empty") String firstName,

        String lastName,

        @Email(message = "Not valid email") String email,

        @Pattern(
                regexp = "^(\\+7|8)[\\s\\-]?\\(?\\d{3}\\)?[\\s\\-]?\\d{3}[\\s\\-]?\\d{2}[\\s\\-]?\\d{2}$",
                message = "Not valid phone number"
        )
        String phone,

        LocalDateTime registrationDate,

        List<BookLoans> bookLoansList
) {
}
