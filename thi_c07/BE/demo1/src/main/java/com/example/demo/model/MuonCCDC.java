package com.example.demo.model;

import javax.persistence.*;

@Entity
public class MuonCCDC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Integer soLuongMuon;

    private String ngayMuon;

    private String ngayTra;

    @ManyToOne
    @JoinColumn(name = "id_CCDC",referencedColumnName = "id")
    private QuanLyCCDC quanLyCCDC;

    @ManyToOne
    @JoinColumn(name = "id_nhan_vien",referencedColumnName = "id")
    private NhanVien nhanVien;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getSoLuongMuon() {
        return soLuongMuon;
    }

    public void setSoLuongMuon(Integer soLuongMuon) {
        this.soLuongMuon = soLuongMuon;
    }

    public String getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }

    public QuanLyCCDC getQuanLyCCDC() {
        return quanLyCCDC;
    }

    public void setQuanLyCCDC(QuanLyCCDC quanLyCCDC) {
        this.quanLyCCDC = quanLyCCDC;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }
}
