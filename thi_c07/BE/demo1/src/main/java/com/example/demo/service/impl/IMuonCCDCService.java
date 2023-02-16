package com.example.demo.service.impl;

import com.example.demo.model.MuonCCDC;
import com.example.demo.repository.IMuonCCDCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IMuonCCDCService implements com.example.demo.service.IMuonCCDCService {

    @Autowired
    private IMuonCCDCRepository muonCCDCRepository;
    @Override
    public List<MuonCCDC> findAll() {
        return muonCCDCRepository.findAll();
    }

    @Override
    public void save(MuonCCDC muonCCDC) {
        muonCCDCRepository.save(muonCCDC);
    }
}
