package com.example.shop_product.repository.product;

import com.example.shop_product.model.oder.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment,Integer> {
}
