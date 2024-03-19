package com.example.niitiproduct.repositories;

import com.example.niitiproduct.models.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WardRepository extends JpaRepository<Ward, String> {
    @Query("SELECT w FROM Ward w WHERE w.district_code  = ?1")
    List<Ward> findWardsByDistrictCode(String code);
}
