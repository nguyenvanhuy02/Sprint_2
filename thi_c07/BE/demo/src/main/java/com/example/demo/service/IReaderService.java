package com.example.demo.service;

import com.example.demo.model.Reader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IReaderService {
    Page<Reader> findAll(Pageable pageable);

    Reader findById(long id);

    void delete(long id);

    Reader save(Reader reader);

    void edit(Reader reader);
}
