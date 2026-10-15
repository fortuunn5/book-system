package com.example.book_system.controller;

import com.example.book_system.dto.NewReaderDto;
import com.example.book_system.dto.ReaderDto;
import com.example.book_system.service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/readers")
public class ReaderController {
    private final ReaderService readerService;

    @PostMapping
    public ResponseEntity<ReaderDto> createReader(@RequestBody NewReaderDto newReader) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(readerService.createReader(newReader));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReaderDto> getReaderById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(readerService.getReaderById(id));
    }

    @GetMapping
    public ResponseEntity<List<ReaderDto>> getAllReaders() {
        return ResponseEntity.ok(readerService.getAllReaders());
    }

    @PutMapping
    public ResponseEntity<ReaderDto> updateReader(@RequestBody ReaderDto upReader) {
        return ResponseEntity.ok(readerService.updateReader(upReader));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReaderById(@PathVariable(name = "id") Long id) {
        readerService.deleteReaderById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .build();
    }
}
