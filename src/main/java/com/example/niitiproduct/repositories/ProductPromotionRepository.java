package com.example.niitiproduct.repositories;

import com.example.niitiproduct.models.ProductPromotion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductPromotionRepository extends CrudRepository<ProductPromotion, Long> {
    List<ProductPromotion> findFirstByProduct_IdOrderByIdDesc(Integer productId);
}
