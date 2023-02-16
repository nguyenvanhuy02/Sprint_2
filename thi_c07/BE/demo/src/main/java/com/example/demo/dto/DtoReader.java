package com.example.demo.dto;

import com.example.demo.model.Book;
import org.springframework.validation.annotation.Validated;

import java.lang.annotation.Annotation;

public class DtoReader implements Validated {
    private long id;

    private String name;

    private int yearOld;

    private boolean deleteReader;

    private Book book;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOld() {
        return yearOld;
    }

    public void setYearOld(int yearOld) {
        this.yearOld = yearOld;
    }

    public boolean isDeleteReader() {
        return deleteReader;
    }

    public void setDeleteReader(boolean deleteReader) {
        this.deleteReader = deleteReader;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public Class<?>[] value() {
        return new Class[0];
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
