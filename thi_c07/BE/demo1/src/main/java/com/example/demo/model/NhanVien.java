package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class NhanVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String maNhanVien;

    private String tenNhanVien;

    @ManyToOne
    @JoinColumn(name = "id_vi_tri",referencedColumnName = "id")
    private ViTri viTri;

    @JsonBackReference
    @OneToMany(mappedBy = "nhanVien")
    private Set<MuonCCDC> muonCCDCS;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public ViTri getViTri() {
        return viTri;
    }

    public void setViTri(ViTri viTri) {
        this.viTri = viTri;
    }

    public Set<MuonCCDC> getMuonCCDCS() {
        return muonCCDCS;
    }

    public void setMuonCCDCS(Set<MuonCCDC> muonCCDCS) {
        this.muonCCDCS = muonCCDCS;
    }
}
