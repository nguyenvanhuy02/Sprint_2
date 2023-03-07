package com.example.shop_product.dto;

public class OrderDto {

    private Integer user;

    private Integer quantity;

    private Integer clothes;

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getClothes() {
        return clothes;
    }

    public void setClothes(Integer clothes) {
        this.clothes = clothes;
    }
}
