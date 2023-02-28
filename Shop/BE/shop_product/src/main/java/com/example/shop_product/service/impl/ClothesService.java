package com.example.shop_product.service.impl;

import com.example.shop_product.model.product.Clothes;
import com.example.shop_product.repository.product.IClothesRepository;
import com.example.shop_product.service.IClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClothesService implements IClothesService {

    @Autowired
    private IClothesRepository clothesRepository;


    @Override
    public Page<Clothes> findAll(Pageable pageable) {
        return clothesRepository.findAll(pageable);
    }
}
