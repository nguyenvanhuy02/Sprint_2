package com.example.demo.service;

import com.example.demo.model.MuonCCDC;

import java.util.List;

public interface IMuonCCDCService {
    List<MuonCCDC> findAll();

    void save(MuonCCDC muonCCDC);
}
