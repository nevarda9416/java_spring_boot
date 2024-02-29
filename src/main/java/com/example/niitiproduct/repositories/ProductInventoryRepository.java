package com.example.niitiproduct.repositories;

import com.example.niitiproduct.models.ProductInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInventoryRepository extends JpaRepository<ProductInventory, Long> {
}