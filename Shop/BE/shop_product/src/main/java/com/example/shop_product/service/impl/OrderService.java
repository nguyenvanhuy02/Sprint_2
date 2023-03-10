package com.example.shop_product.service.impl;

import com.example.shop_product.model.oder.OrderClothes;
import com.example.shop_product.model.oder.OrderDetail;
import com.example.shop_product.repository.product.IOrderDetailRepository;
import com.example.shop_product.repository.product.IOrderRepository;
import com.example.shop_product.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderRepository orderRepository;

    @Autowired
    private IOrderDetailRepository orderDetailRepository;


    @Override
    public OrderClothes getOrder(Integer user) {
        return orderRepository.getOrder(user);
    }

    @Override
    public void addOrder(OrderClothes orderClothes) {
        orderRepository.save(orderClothes);
    }

    @Override
    public void addOrderDetail(OrderDetail orderDetail) {
        orderDetailRepository.save(orderDetail);

    }

    @Override
    public List<OrderDetail> getCartByUserId(String id) {
        return orderDetailRepository.getCartByUserId(id);
    }

    @Override
    public OrderDetail getOrderDetail(Integer id) {
        return orderDetailRepository.findById(id).orElse(null);
    }

    @Override
    public List<OrderDetail> getHistory(String id) {
        return orderDetailRepository.getHistory(id);
    }

    @Override
    public Page<OrderDetail> getPageHistory(String id, Pageable pageable) {
        return orderDetailRepository.getPageHistory(id,pageable);
    }
}
