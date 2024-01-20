package com.example.niitiproduct.services;

import com.example.niitiproduct.dto.CommentDTO;
import com.example.niitiproduct.mapper.CommentMapper;
import com.example.niitiproduct.models.Comment;
import com.example.niitiproduct.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    private CommentRepository commentRepository;
    public List<CommentDTO> getAll() {
        return commentRepository.findAllByOrderByIdDesc().stream().map(e->commentMapper.toDTO(e)).toList();
    }
    public boolean save(Comment comment) {
        try {
            Comment commentData = new Comment();
            commentData.setCreated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            commentData.setCreated_by(String.valueOf(1));
            commentData.setUpdated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            commentData.setUpdated_by(String.valueOf(1));
            commentRepository.save(commentData);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}