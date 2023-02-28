package com.example.shop_product.repository.product;

import com.example.shop_product.model.product.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IClothesRepository extends JpaRepository<Clothes, Integer> {
}
