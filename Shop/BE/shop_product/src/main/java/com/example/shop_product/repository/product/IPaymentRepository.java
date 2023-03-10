package com.example.shop_product.repository.product;

import com.example.shop_product.model.oder.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment,Integer> {

    @Query(value = "select payment.* from payment \n" +
            "            join order_clothes on order_clothes.payment_id = payment.id \n" +
            "            join user on user.id = order_clothes.user_id \n" +
            "            where order_clothes.user_id = :id and payment.payment_status = 0",nativeQuery = true)
    Payment getPaymentByUserId(@Param("id") Integer id);
}
