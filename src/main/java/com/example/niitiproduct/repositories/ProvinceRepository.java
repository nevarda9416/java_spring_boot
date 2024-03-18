package com.example.niitiproduct.repositories;

import com.example.niitiproduct.models.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProvinceRepository extends JpaRepository<Province, Integer> {
    @Query("SELECT p FROM Province p WHERE p.administrative_region_id = ?1")
    List<Province> findProvincesByAdministrative_region_id(Integer regionId);
}
