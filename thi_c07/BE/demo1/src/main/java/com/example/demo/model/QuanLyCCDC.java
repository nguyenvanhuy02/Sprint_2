package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class QuanLyCCDC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String maCCDC;

    private String tenCCDC;

    private String hangSX;

    private String donVi;

    private Integer soLuong;

    @JsonBackReference
    @OneToMany(mappedBy = "quanLyCCDC")
    private Set<MuonCCDC> muonCCDCS;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaCCDC() {
        return maCCDC;
    }

    public void setMaCCDC(String maCCDC) {
        this.maCCDC = maCCDC;
    }

    public String getTenCCDC() {
        return tenCCDC;
    }

    public void setTenCCDC(String tenCCDC) {
        this.tenCCDC = tenCCDC;
    }

    public String getHangSX() {
        return hangSX;
    }

    public void setHangSX(String hangSX) {
        this.hangSX = hangSX;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Set<MuonCCDC> getMuonCCDCS() {
        return muonCCDCS;
    }

    public void setMuonCCDCS(Set<MuonCCDC> muonCCDCS) {
        this.muonCCDCS = muonCCDCS;
    }
}
