package com.example.niitiproduct.repositories;

import com.example.niitiproduct.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findAllByOrderByIdDesc(Pageable pageable);

    Page<Category> findByNameContaining(String name, Pageable pageable);
}
