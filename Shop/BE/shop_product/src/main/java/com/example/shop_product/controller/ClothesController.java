package com.example.shop_product.controller;

import com.example.shop_product.model.product.Clothes;
import com.example.shop_product.service.IClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/clothes")
public class ClothesController {

    @Autowired
    private IClothesService clothesService;

    @GetMapping
    public ResponseEntity<Page<Clothes>> getClothes(@PageableDefault(value = 6) Pageable pageable) {
        Page<Clothes> clothes = clothesService.findAll(pageable);
        if (clothes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(clothes, HttpStatus.OK);
    }

    @GetMapping("/home")
    public ResponseEntity<List<Clothes>> getClothesHome(){
        List<Clothes> clothesList = clothesService.findAllHome();
        if (clothesList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(clothesList, HttpStatus.OK);
    }

    @GetMapping("detail/{id}")
    public ResponseEntity<Clothes> detailClothes(@PathVariable Integer id){
        Clothes clothes = clothesService.findById(id);
        try {
            if (clothes == null || clothes.isDeleteStatus()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (NullPointerException e) {
            e.getStackTrace();
        }
        return new ResponseEntity<>(clothes, HttpStatus.OK);
    }
}
