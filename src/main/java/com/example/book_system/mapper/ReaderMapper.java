package com.example.book_system.mapper;

import com.example.book_system.dto.NewReaderDto;
import com.example.book_system.dto.ReaderDto;
import com.example.book_system.model.Reader;

import java.util.ArrayList;
import java.util.List;

public class ReaderMapper {
    public static Reader toEntity(ReaderDto readerDto) {
        return new Reader(
                readerDto.id(),
                readerDto.firstName(),
                readerDto.lastName(),
                readerDto.email(),
                readerDto.phone(),
                readerDto.registrationDate(),
                BookLoanMapper.toEntity(readerDto.bookLoanList())
        );
    }

    public static ReaderDto toDto(Reader reader) {
        return new ReaderDto(
                reader.getId(),
                reader.getFirstName(),
                reader.getLastName(),
                reader.getEmail(),
                reader.getPhone(),
                reader.getRegistrationDate(),
                BookLoanMapper.toDto(reader.getBookLoanList())
        );
    }

    public static List<ReaderDto> toDto(List<Reader> readers) {
        return readers.stream()
                .map(ReaderMapper::toDto)
                .toList();
    }

    public static List<Reader> toEntity(List<ReaderDto> readerDtoList) {
        if (readerDtoList == null || readerDtoList.isEmpty()) {
            return new ArrayList<>();
        }
        return readerDtoList.stream()
                .map(ReaderMapper::toEntity)
                .toList();
    }

    public static Reader toEntity(NewReaderDto readerDto) {
        return new Reader(
                null,
                readerDto.firstName(),
                readerDto.lastName(),
                readerDto.email(),
                readerDto.phone(),
                null,
                null
        );
    }
}
