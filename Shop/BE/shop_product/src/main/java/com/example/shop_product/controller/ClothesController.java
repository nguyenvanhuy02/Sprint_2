package com.example.shop_product.controller;

import com.example.shop_product.model.product.Clothes;
import com.example.shop_product.service.IClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/clothes")
public class ClothesController {

    @Autowired
    private IClothesService clothesService;

    @GetMapping
    public ResponseEntity<Page<Clothes>> getClothes(@PageableDefault(value = 5) Pageable pageable) {
        Page<Clothes> clothes = clothesService.findAll(pageable);
        if (clothes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(clothes, HttpStatus.OK);
    }
}
