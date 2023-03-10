package com.example.shop_product.repository.product;

import com.example.shop_product.dto.ClothesDto;
import com.example.shop_product.dto.IClothesDto;
import com.example.shop_product.model.product.Clothes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IClothesRepository extends JpaRepository<Clothes, Integer> {

    @Query(value = "SELECT * FROM shop_product.clothes WHERE delete_status = 0 ORDER BY date_submitted DESC LIMIT 6", nativeQuery = true)
    List<Clothes> findAllHome();

    @Query(value = "select clo.id as id ,\n" +
            "            clo.name as name ,\n" +
            "            ig.url as url ,\n" +
            "            clo.gender as gender ,\n" +
            "            clo.price as price\n" +
            "             from `clothes` clo \n" +
            "            join `image` ig on ig.id_clothes = clo.id \n" +
            "            where clo.gender like %:#{#clothesDto.gender}%" +
            "            and clo.name like %:#{#clothesDto.name}% " +
            "group by clo.id", nativeQuery = true)
    Page<IClothesDto> findAllClothesDto(@Param("clothesDto") ClothesDto clothesDto, Pageable pageable);
}
