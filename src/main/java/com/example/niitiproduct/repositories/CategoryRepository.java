package com.example.niitiproduct.repositories;

import com.example.niitiproduct.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    public List<Category> findAllByOrderByIdDesc();

    List<Category> findByNameContaining(String name);
}
