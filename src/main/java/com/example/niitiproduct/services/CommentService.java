package com.example.niitiproduct.services;

import com.example.niitiproduct.dto.CommentDTO;
import com.example.niitiproduct.mapper.CommentMapper;
import com.example.niitiproduct.models.Comment;
import com.example.niitiproduct.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    /**
     * Get all comments
     * @return
     */
    public List<CommentDTO> getAll() {
        return commentRepository.findAllByOrderByIdDesc().stream().map(e->commentMapper.toDTO(e)).toList();
    }

    /**
     * Search by comment name
     * @param content
     * @return
     */
    public List<Comment> searchByContent(String content) {
        return commentRepository.findByContentContaining(content);
    }

    /**
     * Edit comment
     * @param id
     * @return
     */
    public Comment findById(Long id) {
        return commentRepository.findById(Math.toIntExact(id)).get();
    }

    public boolean save(Comment comment) {
        try {
            Comment commentData = new Comment();
            commentData.setId(comment.getId());
            commentData.setProduct_id(comment.getProduct_id());
            commentData.setType(comment.getType());
            commentData.setSource(comment.getSource());
            commentData.setAuthor_name(comment.getAuthor_name());
            commentData.setAuthor_phone(comment.getAuthor_phone());
            commentData.setAuthor_email(comment.getAuthor_email());
            commentData.setAuthor_address(comment.getAuthor_address());
            commentData.setAuthor_ip(comment.getAuthor_ip());
            commentData.setAuthor_agent(comment.getAuthor_agent());
            commentData.setContent(comment.getContent());
            commentData.setStatus(comment.getStatus());
            commentData.setPublished_at(comment.getPublished_at());
            commentData.setCustomer_id(comment.getCustomer_id());
            commentData.setIs_highlight(comment.getIs_highlight());
            commentData.setIs_sticky(comment.getIs_sticky());
            commentData.setIs_closed(comment.getIs_closed());
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

    /**
     * Delete comment
     * @param id
     */
    public void delete(Long id) {
        try {
            commentRepository.deleteById(Math.toIntExact(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ResponseEntity<Object> getAllComments() {
        List<Comment> commentList = commentRepository.findAll();
        return new ResponseEntity<>(commentList, HttpStatus.OK);
    }

    public ResponseEntity<Object> getCommentsByProductId(Integer productId) {
        List<Comment> commentList = commentRepository.findCommentsByProductId(productId);
        return new ResponseEntity<>(commentList, HttpStatus.OK);
    }
}