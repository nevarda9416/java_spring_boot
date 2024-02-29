package com.example.niitiproduct.repositories;

import com.example.niitiproduct.models.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, Long> {
    List<UserRole> findFirstByUser_IdOrderByIdDesc(Integer userId);
    @Query(value = "INSERT INTO users_roles (id, role_id, user_id) VALUES (:id, :role_id, :user_id)", nativeQuery = true)
    void insertRaw(@Param("id") Long id, @Param("role_id") Integer role_id, @Param("user_id") Integer user_id);
}
