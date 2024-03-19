package com.example.niitiproduct.repositories;

import com.example.niitiproduct.models.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DistrictRepository extends JpaRepository<District, String> {
    @Query("SELECT d FROM District d WHERE d.province_code = ?1")
    List<District> findDistrictsByProvinceCode(String code);
}