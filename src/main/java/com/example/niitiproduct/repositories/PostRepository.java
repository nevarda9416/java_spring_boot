package com.example.niitiproduct.repositories;

import com.example.niitiproduct.models.Post;
import com.example.niitiproduct.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findAllByOrderByIdDesc();

    List<Post> findByTitleContaining(String title);

    @Query("SELECT p FROM Post p WHERE p.category_id = ?1 ORDER BY p.id DESC")
    List<Post> findPostsByCategory_id(Integer categoryId);

    @Query(value = "SELECT p.* FROM Posts p WHERE p.slug = ?1", nativeQuery = true)
    List<Map<String, Object>> findBySlug(String slug);
}
