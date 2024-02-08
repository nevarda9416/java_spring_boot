package com.example.niitiproduct.repositories;

import com.example.niitiproduct.models.SellingPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellingPlaceRepository extends JpaRepository<SellingPlace, Integer> {
    List<SellingPlace> findByNameContaining(String name);
}