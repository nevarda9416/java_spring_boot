package com.example.niitiproduct.repositories;

import com.example.niitiproduct.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByOrderByIdDesc();

    List<Product> findByNameContaining(String name);

    @Query("SELECT p FROM Product p WHERE p.category_id = ?1")
    List<Product> findProductsByCategory_id(Integer categoryId);
}
