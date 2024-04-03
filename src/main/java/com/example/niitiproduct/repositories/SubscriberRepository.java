package com.example.niitiproduct.repositories;

import com.example.niitiproduct.models.Subscriber;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriberRepository extends JpaRepository<Subscriber, Integer> {
    List<Subscriber> findAllByOrderByIdDesc(Pageable pageable);

    Page<Subscriber> findByEmailContaining(String email, Pageable pageable);
}
