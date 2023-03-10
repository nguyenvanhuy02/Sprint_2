package com.example.shop_product.service;

import com.example.shop_product.model.oder.Payment;

public interface IPaymentService {
    void addPayment(Payment payment);

    Payment getPaymentByUserId(Integer id);

}
