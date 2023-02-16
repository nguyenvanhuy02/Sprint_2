package com.example.demo.service.impl;

import com.example.demo.model.Reader;
import com.example.demo.repository.IReaderRepository;
import com.example.demo.service.IReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.swing.*;

@Service
public class ReaderService implements IReaderService {
    @Autowired
    private IReaderRepository readerRepository;

    @Override
    public Page<Reader> findAll(Pageable pageable) {
        return readerRepository.findAll(pageable);
    }

    @Override
    public Reader findById(long id) {
        return readerRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(long id) {
        readerRepository.delete(id);
    }

    @Override
    public Reader save(Reader reader) {
        return readerRepository.save(reader);
    }

    @Override
    public void edit(Reader reader) {
        readerRepository.save(reader);
        readerRepository.update(reader.getName(), reader.getYearOld(), reader.getBook().getId(), reader.getId());
    }


}
