package com.example.demo.service.impl;

import com.example.demo.model.QuanLyCCDC;
import com.example.demo.repository.IQuanLyCCDCReposiotyr;
import com.example.demo.service.IQuanLyCCDCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuanLyCCDCService implements IQuanLyCCDCService {
    @Autowired
    private IQuanLyCCDCReposiotyr quanLyCCDCReposiotyr;

    @Override
    public Page<QuanLyCCDC> findAll(Pageable pageable) {
        return quanLyCCDCReposiotyr.findAll(pageable);
    }

    @Override
    public void save(QuanLyCCDC quanLyCCDC) {
        quanLyCCDCReposiotyr.save(quanLyCCDC);
    }

    @Override
    public QuanLyCCDC findById(Integer id) {
        return quanLyCCDCReposiotyr.findById(id).orElse(null);
    }

    @Override
    public List<QuanLyCCDC> danhSach() {
        return quanLyCCDCReposiotyr.findAll();
    }
}
