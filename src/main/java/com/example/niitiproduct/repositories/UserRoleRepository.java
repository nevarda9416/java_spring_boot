package com.example.niitiproduct.repositories;

import com.example.niitiproduct.models.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, Long> {
    List<UserRole> findFirstByUser_IdOrderByIdDesc(Integer userId);
}
