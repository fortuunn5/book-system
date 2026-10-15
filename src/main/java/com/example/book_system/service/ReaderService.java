package com.example.book_system.service;

import com.example.book_system.dto.NewReaderDto;
import com.example.book_system.dto.ReaderDto;

import java.util.List;

public interface ReaderService {
    ReaderDto createReader(NewReaderDto reader);

    ReaderDto getReaderById(Long id);

    List<ReaderDto> getAllReaders();

    ReaderDto updateReader(ReaderDto reader);

    void deleteReaderById(Long id);
}
