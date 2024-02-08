package com.example.niitiproduct.repositories;

import com.example.niitiproduct.models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    public List<Inventory> findAllByOrderByIdDesc();

    List<Inventory> findByNameContaining(String name);
}