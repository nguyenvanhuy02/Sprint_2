package com.example.demo.controller;

import com.example.demo.dto.DtoReader;
import com.example.demo.model.Reader;
import com.example.demo.service.IReaderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/reader")
public class ReaderController {

    @Autowired
    private IReaderService readerService;

    @GetMapping
    public ResponseEntity<Page<Reader>> getReaderList(@PageableDefault(value = 2) Pageable pageable) {
        Page<Reader> readers = readerService.findAll(pageable);
        if (readers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(readers, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Reader> delete(@PathVariable("id") long id) {
        Reader reader = readerService.findById(id);
        if (reader == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        readerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Reader reader) {
        readerService.save(reader);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Reader> edit(@RequestBody @PathVariable("id") long id) {
        Reader reader = readerService.findById(id);
        if (reader == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        readerService.save(reader);
        return new ResponseEntity<>(reader, HttpStatus.OK);
    }

    @PatchMapping("update")
    public ResponseEntity<DtoReader> update(@Valid
                                            @RequestBody DtoReader dtoReader,
                                            BindingResult bindingResult) {
        if (readerService.findById(dtoReader.getId()) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        Reader reader = new Reader();
        BeanUtils.copyProperties(dtoReader, reader);
        readerService.save(reader);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
