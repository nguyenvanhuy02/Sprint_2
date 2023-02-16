package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ViTri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String tenVitri;

    @JsonBackReference
    @OneToMany(mappedBy = "viTri")
    private Set<NhanVien> nhanViens;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenVitri() {
        return tenVitri;
    }

    public void setTenVitri(String tenVitri) {
        this.tenVitri = tenVitri;
    }

    public Set<NhanVien> getNhanViens() {
        return nhanViens;
    }

    public void setNhanViens(Set<NhanVien> nhanViens) {
        this.nhanViens = nhanViens;
    }
}
