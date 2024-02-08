package com.example.niitiproduct.repositories;

import com.example.niitiproduct.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllByOrderByIdDesc();
    List<Order> findByCodeContaining(String code);
}