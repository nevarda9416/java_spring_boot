package com.example.niitiproduct.repositories;

import com.example.niitiproduct.models.Pages;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageRepository extends JpaRepository<Pages, Integer> {
    List<Pages> findAllByOrderByIdDesc(Pageable pageable);

    List<Pages> findByTitleContaining(String title);

    @Query("SELECT p FROM Pages p WHERE p.category_id = ?1")
    List<Pages> findPagesByCategory_id(Integer categoryId);
}
