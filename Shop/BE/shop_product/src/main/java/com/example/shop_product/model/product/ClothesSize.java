package com.example.shop_product.model.product;

import com.example.shop_product.model.account.Role;

import javax.persistence.*;

@Entity
public class ClothesSize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "clothes_id",referencedColumnName = "id")
    private Clothes clothes;

    @ManyToOne
    @JoinColumn(name = "size_id",referencedColumnName = "id")
    private Size size;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
