package com.example.shop_product.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private boolean deleteStatus;

    @JsonBackReference
    @OneToMany(mappedBy = "size")
    private Set<Clothes> Clothes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }


    public Set<com.example.shop_product.model.product.Clothes> getClothes() {
        return Clothes;
    }

    public void setClothes(Set<com.example.shop_product.model.product.Clothes> clothes) {
        Clothes = clothes;
    }
}
