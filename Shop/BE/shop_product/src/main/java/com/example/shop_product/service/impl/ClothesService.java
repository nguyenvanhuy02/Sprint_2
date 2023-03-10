package com.example.shop_product.service.impl;

import com.example.shop_product.dto.ClothesDto;
import com.example.shop_product.dto.IClothesDto;
import com.example.shop_product.model.product.Clothes;
import com.example.shop_product.repository.product.IClothesRepository;
import com.example.shop_product.service.IClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothesService implements IClothesService {

    @Autowired
    private IClothesRepository clothesRepository;


    @Override
    public Page<Clothes> findAll(Pageable pageable) {
        return clothesRepository.findAll(pageable);
    }

    @Override
    public List<Clothes> findAllHome() {
        return clothesRepository.findAllHome();
    }

    @Override
    public Clothes findById(Integer id) {
        return clothesRepository.findById(id).orElse(null);
    }

    @Override
    public Page<IClothesDto> findAllClothes(ClothesDto clothesDto, Pageable pageable) {
        return clothesRepository.findAllClothesDto(clothesDto,pageable);
    }
}
