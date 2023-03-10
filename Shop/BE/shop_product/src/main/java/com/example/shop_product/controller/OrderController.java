package com.example.shop_product.controller;

import com.example.shop_product.dto.OrderDto;
import com.example.shop_product.model.oder.OrderClothes;
import com.example.shop_product.model.oder.OrderDetail;
import com.example.shop_product.model.oder.Payment;
import com.example.shop_product.model.product.Clothes;
import com.example.shop_product.service.IClothesService;
import com.example.shop_product.service.IOrderService;
import com.example.shop_product.service.IPaymentService;
import com.example.shop_product.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IPaymentService paymentService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IClothesService clothesService;


    @GetMapping("cart/{id}")
    public ResponseEntity<List<OrderDetail>> getListProductDetailByUserId(@PathVariable String id) {
        List<OrderDetail> orderDetails = orderService.getCartByUserId(id);
        if (orderDetails.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(orderDetails, HttpStatus.OK);
    }

    @PostMapping("/addOrder")
    public ResponseEntity<OrderClothes> add(@RequestBody OrderDto order) {
        OrderClothes orderClothes = orderService.getOrder(order.getUser());
        if (orderClothes == null) {

            Payment payment = new Payment();
            payment.setDeleteStatus(true);
            payment.setPaymentStatus(false);
            payment.setShippingDescription("");
            paymentService.addPayment(payment);


            OrderClothes orderClothesNew = new OrderClothes();
            orderClothesNew.setPayment(payment);
            orderClothesNew.setUser(userService.getUserById(order.getUser()));
            orderClothesNew.setDeleteStatus(true);
            orderService.addOrder(orderClothesNew);

            OrderClothes orderClothes1 = orderService.getOrder(order.getUser());

            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderClothes(orderClothes1);
            orderDetail.setClothes(clothesService.findById(order.getClothes()));
            orderDetail.setQuantity(order.getQuantity());
            orderService.addOrderDetail(orderDetail);


            return new ResponseEntity<>(orderClothes1, HttpStatus.OK);
        }

        OrderDetail orderDetail = new OrderDetail();
        Clothes clothes = clothesService.findById(order.getClothes());
        List<OrderDetail> orderDetails = orderService.getCartByUserId(String.valueOf(order.getUser()));

        for (OrderDetail x : orderDetails) {
            if (x.getClothes().getId() == clothes.getId()) {
                x.setQuantity(x.getQuantity() + order.getQuantity());
                orderService.addOrderDetail(x);
                return new ResponseEntity<>(orderClothes, HttpStatus.OK);
            }
        }
        orderDetail.setOrderClothes(orderClothes);
        orderDetail.setClothes(clothes);
        orderDetail.setQuantity(order.getQuantity());
        orderService.addOrderDetail(orderDetail);

        return new ResponseEntity<>(orderClothes, HttpStatus.OK);
    }

    @GetMapping("minus/{id}")
    public ResponseEntity<OrderDetail> minus(@PathVariable Integer id) {
        OrderDetail orderDetail = orderService.getOrderDetail(id);
        orderDetail.setQuantity(orderDetail.getQuantity() - 1);
        orderService.addOrderDetail(orderDetail);
        return new ResponseEntity<>(orderDetail, HttpStatus.OK);
    }
    @GetMapping("plus/{id}")
    public ResponseEntity<OrderDetail> plus(@PathVariable Integer id) {
        OrderDetail orderDetail = orderService.getOrderDetail(id);
        orderDetail.setQuantity(orderDetail.getQuantity() + 1);
        orderService.addOrderDetail(orderDetail);
        return new ResponseEntity<>(orderDetail, HttpStatus.OK);
    }

    @GetMapping("payment/{id}")
    public ResponseEntity<Payment> payment(@PathVariable Integer id, @RequestParam String note) {
        Payment payment = paymentService.getPaymentByUserId(id);
        payment.setPaymentStatus(true);
        if(note.length() == 0) {
            payment.setShippingDescription("Khong co ghi chu");
        } else {
            payment.setShippingDescription(note);
        }
        paymentService.addPayment(payment);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    @GetMapping("history/{id}")
    public ResponseEntity<List<OrderDetail>> getHistory(@PathVariable String id) {
        List<OrderDetail> orderDetails = orderService.getHistory(id);
        if (orderDetails.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(orderDetails, HttpStatus.OK);
    }

    @GetMapping("historypage/{id}")
    public ResponseEntity<Page<OrderDetail>> getPageHistory(@PathVariable String id , Pageable pageable) {
        Page<OrderDetail> orderDetails = orderService.getPageHistory(id,pageable);
        if (orderDetails.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(orderDetails, HttpStatus.OK);
    }
}
