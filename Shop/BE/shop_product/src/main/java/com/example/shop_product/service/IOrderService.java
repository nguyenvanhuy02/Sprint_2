package com.example.shop_product.service;

import com.example.shop_product.model.oder.OrderClothes;
import com.example.shop_product.model.oder.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IOrderService {

    OrderClothes getOrder(Integer user);

    void addOrder(OrderClothes orderClothes);

    void addOrderDetail(OrderDetail orderDetail);

    List<OrderDetail> getCartByUserId(String id);

    OrderDetail getOrderDetail(Integer id);

    List<OrderDetail> getHistory(String id);

    Page<OrderDetail> getPageHistory(String id , Pageable pageable);
}
