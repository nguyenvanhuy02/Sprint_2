package com.example.shop_product.repository.product;

import com.example.shop_product.model.oder.OrderClothes;
import com.example.shop_product.model.oder.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IOrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
    @Query(value = "select order_detail.* from order_detail \n" +
            "            join `order_clothes` on order_clothes.id = order_detail.order_clothes_id\n" +
            "            join `user` on `user`.id = order_clothes.user_id\n" +
            "            join `payment` on payment.id = order_clothes.payment_id \n" +
            "            join `clothes` on clothes.id = order_detail.clothes_id where payment.payment_status = 0 and user.id = :userId", nativeQuery = true)
    List<OrderDetail> getCartByUserId(@Param("userId") String id);


    @Query(value = "select order_detail.* from order_detail\n" +
            "join order_clothes on order_clothes.id = order_detail.order_clothes_id\n" +
            "join clothes on clothes.id = order_detail.clothes_id\n" +
            "join payment on order_clothes.payment_id = payment.id\n" +
            "join `user` on order_clothes.user_id = `user`.id\n" +
            "where payment.delete_status = 1 and `user`.id = :userId", nativeQuery = true)
    List<OrderDetail> getHistory(@Param("userId") String id);

    @Query(value = "select order_detail.* from order_detail\n" +
            "join order_clothes on order_clothes.id = order_detail.order_clothes_id\n" +
            "join clothes on clothes.id = order_detail.clothes_id\n" +
            "join payment on order_clothes.payment_id = payment.id\n" +
            "join `user` on order_clothes.user_id = `user`.id\n" +
            "where payment.delete_status = 1 and `user`.id = :userId", nativeQuery = true)
    Page<OrderDetail> getPageHistory(@Param("userId") String id, Pageable pageable);
}
