package com.example.niitiproduct.repositories;

import com.example.niitiproduct.models.Product;
import com.example.niitiproduct.models.Warranty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarrantyRepository extends JpaRepository<Warranty, Integer> {
}
