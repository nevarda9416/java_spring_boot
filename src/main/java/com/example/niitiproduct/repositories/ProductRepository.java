package com.example.niitiproduct.repositories;

import com.example.niitiproduct.models.Category;
import com.example.niitiproduct.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    public List<Product> findAllByOrderByIdDesc();

    List<Product> findByNameContaining(String name);
}
