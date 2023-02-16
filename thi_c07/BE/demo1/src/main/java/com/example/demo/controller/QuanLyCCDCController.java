package com.example.demo.controller;

import com.example.demo.model.MuonCCDC;
import com.example.demo.model.NhanVien;
import com.example.demo.model.QuanLyCCDC;
import com.example.demo.service.IMuonCCDCService;
import com.example.demo.service.INhanVienService;
import com.example.demo.service.IQuanLyCCDCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/ccdc")
public class QuanLyCCDCController {

    @Autowired
    private IQuanLyCCDCService quanLyCCDCService;

    @Autowired
    private IMuonCCDCService muonCCDCService;

    @Autowired
    private INhanVienService nhanVienService;

    @GetMapping
    public ResponseEntity<Page<QuanLyCCDC>> getQuanLy(@PageableDefault(value = 5) Pageable pageable) {
        Page<QuanLyCCDC> quanLyCCDCS = quanLyCCDCService.findAll(pageable);
        if (quanLyCCDCS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(quanLyCCDCS, HttpStatus.OK);
    }

    @PostMapping("/them")
    public ResponseEntity<?> theMoi(@RequestBody QuanLyCCDC quanLyCCDC) {
        quanLyCCDCService.save(quanLyCCDC);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/muon")
    public ResponseEntity<List<MuonCCDC>> getQuanLy() {
        List<MuonCCDC> muonCCDCS = muonCCDCService.findAll();
        if (muonCCDCS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(muonCCDCS, HttpStatus.OK);
    }

    @GetMapping("detail/{id}")
    public ResponseEntity<QuanLyCCDC>detail(@PathVariable Integer id){
        QuanLyCCDC quanLyCCDC = quanLyCCDCService.findById(id);
        try {
            if (quanLyCCDC == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (NullPointerException e) {
            e.getStackTrace();
        }
        return new ResponseEntity<>(quanLyCCDC, HttpStatus.OK);
    }

    @PostMapping("/muonccdc")
    public ResponseEntity<?> muon(@RequestBody MuonCCDC muonCCDC) {
        muonCCDCService.save(muonCCDC);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/nhanvien")
    public ResponseEntity<List<NhanVien>> getNhanVien() {
        List<NhanVien> nhanViens = nhanVienService.findAll();
        if (nhanViens.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(nhanViens, HttpStatus.OK);
    }

    @GetMapping("/quanly")
    public ResponseEntity<List<QuanLyCCDC>> getQuanLyCCDC() {
        List<QuanLyCCDC> quanLyCCDCS = quanLyCCDCService.danhSach();
        if (quanLyCCDCS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(quanLyCCDCS, HttpStatus.OK);
    }
}
