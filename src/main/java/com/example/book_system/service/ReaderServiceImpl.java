package com.example.book_system.service;

import com.example.book_system.dto.NewReaderDto;
import com.example.book_system.dto.ReaderDto;
import com.example.book_system.exception.EntityNotFoundException;
import com.example.book_system.mapper.ReaderMapper;
import com.example.book_system.model.Reader;
import com.example.book_system.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReaderServiceImpl implements ReaderService {
    private final ReaderRepository readerRepository;

    @Override
    public ReaderDto createReader(NewReaderDto newReaderDto) {
        Reader newReader = ReaderMapper.toEntity(newReaderDto);
        newReader.setRegistrationDate(LocalDateTime.now());
        return ReaderMapper.toDto(readerRepository.save(newReader));
    }

    @Override
    public ReaderDto getReaderById(Long id) {
        Reader reader = readerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reader not found with id: " + id));
        return ReaderMapper.toDto(reader);
    }

    @Override
    public List<ReaderDto> getAllReaders() {
        return ReaderMapper.toDto(readerRepository.findAll());
    }

    @Override
    public ReaderDto updateReader(ReaderDto readerDto) {
        Reader upReader = ReaderMapper.toEntity(readerDto);
        return ReaderMapper.toDto(readerRepository.save(upReader));
    }

    @Override
    public void deleteReaderById(Long id) {
        readerRepository.deleteById(id);
    }
}
