package com.example.shop_product.model.product;

import com.example.shop_product.model.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Clothes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private Double price;
    private String dateSubmitted;
    private Integer quantity;
    private boolean deleteStatus;

    @ManyToOne
    @JoinColumn(name = "id_discount",referencedColumnName = "id")
    private Discount discount;

    @JsonBackReference
    @OneToMany(mappedBy = "clothes")
    private Set<ClothesSize> clothesSizes;

    @JsonBackReference
    @OneToMany(mappedBy = "clothes")
    private Set<Image> images;

    @JsonBackReference
    @OneToMany(mappedBy = "clothes")
    private Set<OrderDetail> orderDetails;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(String dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
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

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public Set<ClothesSize> getClothesSizes() {
        return clothesSizes;
    }

    public void setClothesSizes(Set<ClothesSize> clothesSizes) {
        this.clothesSizes = clothesSizes;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    public Set<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
