package com.example.shop_product.model.oder;


import com.example.shop_product.model.product.Clothes;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer quantity;
    private boolean deleteStatus;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "order_clothes_id", referencedColumnName = "id")
    private OrderClothes orderClothes;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "clothes_id", referencedColumnName = "id")
    private Clothes clothes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public boolean isDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public OrderClothes getOrderClothes() {
        return orderClothes;
    }

    public void setOrderClothes(OrderClothes orderClothes) {
        this.orderClothes = orderClothes;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }
}