package com.example.niitiproduct.repositories;

import com.example.niitiproduct.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    public List<Comment> findAllByOrderByIdDesc();

    List<Comment> findByContentContaining(String content);
    @Query("SELECT c FROM Comment c WHERE c.product_id = ?1")
    List<Comment> findCommentsByProductId(Integer product_id);
}