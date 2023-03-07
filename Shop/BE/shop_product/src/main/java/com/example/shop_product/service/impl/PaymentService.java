package com.example.shop_product.service.impl;

import com.example.shop_product.model.oder.Payment;
import com.example.shop_product.repository.product.IPaymentRepository;
import com.example.shop_product.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService implements IPaymentService {

    @Autowired
    private IPaymentRepository paymentRepository;

    @Override
    public void addPayment(Payment payment) {
        paymentRepository.save(payment);
    }
}
