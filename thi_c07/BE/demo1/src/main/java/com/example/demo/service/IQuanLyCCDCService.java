package com.example.demo.service;

import com.example.demo.model.QuanLyCCDC;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IQuanLyCCDCService {
    Page<QuanLyCCDC> findAll(Pageable pageable);

    void save(QuanLyCCDC quanLyCCDC);

    QuanLyCCDC findById(Integer id);

    List<QuanLyCCDC> danhSach();
}
