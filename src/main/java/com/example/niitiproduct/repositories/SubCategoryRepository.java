package com.example.niitiproduct.repositories;

import com.example.niitiproduct.models.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {
    List<SubCategory> findAllByOrderByIdDesc();
    List<SubCategory> findByNameContaining(String name);
}