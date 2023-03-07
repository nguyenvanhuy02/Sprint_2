package com.example.shop_product.service;

import com.example.shop_product.model.product.Clothes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IClothesService {

    Page<Clothes> findAll(Pageable pageable);

    List<Clothes> findAllHome();

    Clothes findById(Integer id);
}
