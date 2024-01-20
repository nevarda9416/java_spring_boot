package com.example.niitiproduct.repositories;

import com.example.niitiproduct.models.Manufacture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManufactureRepository extends JpaRepository<Manufacture, Integer> {
    public List<Manufacture> findAllByOrderByIdDesc();
}
