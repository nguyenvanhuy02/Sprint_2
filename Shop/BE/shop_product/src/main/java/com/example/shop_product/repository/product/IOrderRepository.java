package com.example.shop_product.repository.product;

import com.example.shop_product.model.oder.OrderClothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IOrderRepository extends JpaRepository<OrderClothes,Integer> {

    @Query(value = "select `order_clothes`.* from order_clothes \n" +
            "        join `payment` on order_clothes.payment_id = payment.id \n" +
            "        join `user` on user.id = order_clothes.user_id \n" +
            "        where order_clothes.user_id = :idUser and payment.payment_status = 0 ",nativeQuery = true)
    OrderClothes getOrder(@Param("idUser") Integer user);

}
