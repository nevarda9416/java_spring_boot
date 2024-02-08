package com.example.niitiproduct.mapper;

import com.example.niitiproduct.dto.CommentDTO;
import com.example.niitiproduct.models.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {
    public CommentDTO toDTO(Comment comment) {
        return CommentDTO.builder(
                ).id(comment.getId())
                .product_id(comment.getProduct_id())
                .type(comment.getType())
                .source(comment.getSource())
                .author_name(comment.getAuthor_name())
                .author_phone(comment.getAuthor_phone())
                .author_email(comment.getAuthor_email())
                .author_address(comment.getAuthor_address())
                .author_ip(comment.getAuthor_ip())
                .author_agent(comment.getAuthor_agent())
                .content(comment.getContent())
                .status(comment.getStatus())
                .published_at(comment.getPublished_at())
                .customer_id(comment.getCustomer_id())
                .is_highlight(comment.getIs_highlight())
                .is_sticky(comment.getIs_sticky())
                .is_closed(comment.getIs_closed())
                .created_at(comment.getCreated_at())
                .created_by(comment.getCreated_by())
                .updated_at(comment.getUpdated_at())
                .updated_by(comment.getUpdated_by())
                .deleted_at(comment.getDeleted_at())
                .deleted_by(comment.getDeleted_by())
                .build();
    }
}
