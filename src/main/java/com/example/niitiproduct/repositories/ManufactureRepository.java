package com.example.niitiproduct.repositories;

import com.example.niitiproduct.models.Manufacture;
import com.example.niitiproduct.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManufactureRepository extends JpaRepository<Manufacture, Integer> {
    List<Manufacture> findAllByOrderByIdDesc();
    List<Manufacture> findByNameContaining(String name);
}
