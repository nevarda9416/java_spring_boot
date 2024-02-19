package com.example.niitiproduct.repositories;

import com.example.niitiproduct.models.OrderLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderLogRepository extends JpaRepository<OrderLog, Integer> {
    List<OrderLog> findAllByOrderByIdDesc();
}