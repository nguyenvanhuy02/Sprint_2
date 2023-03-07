package com.example.shop_product.model.oder;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String shippingDescription;

    private Boolean paymentStatus;

    private Boolean deleteStatus;

    @JsonManagedReference
    @OneToOne(mappedBy = "payment")
    private OrderClothes oderClothes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShippingDescription() {
        return shippingDescription;
    }

    public void setShippingDescription(String shippingDescription) {
        this.shippingDescription = shippingDescription;
    }

    public Boolean getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public OrderClothes getOderClothes() {
        return oderClothes;
    }

    public void setOderClothes(OrderClothes oderClothes) {
        this.oderClothes = oderClothes;
    }
}