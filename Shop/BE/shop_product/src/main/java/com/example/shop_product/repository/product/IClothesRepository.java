package com.example.shop_product.repository.product;

import com.example.shop_product.model.product.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IClothesRepository extends JpaRepository<Clothes, Integer> {

    @Query(value = "SELECT * FROM shop_product.clothes WHERE delete_status = 0 ORDER BY date_submitted DESC LIMIT 6",nativeQuery = true)
    List<Clothes> findAllHome();
}
