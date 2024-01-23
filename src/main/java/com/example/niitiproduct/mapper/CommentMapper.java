package com.example.niitiproduct.mapper;

import com.example.niitiproduct.dto.CommentDTO;
import com.example.niitiproduct.models.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {
    public CommentDTO toDTO(Comment comment) {
        return CommentDTO.builder(
                ).id(comment.getId())
                .product_id(comment.getC00_product_id())
                .type(comment.getC01_type())
                .source(comment.getC02_source())
                .author_name(comment.getC03_author_name())
                .author_phone(comment.getC04_author_phone())
                .author_email(comment.getC05_author_email())
                .author_address(comment.getC06_author_address())
                .author_ip(comment.getC07_author_ip())
                .author_agent(comment.getC08_author_agent())
                .content(comment.getC09_content())
                .status(comment.getC10_status())
                .published_at(comment.getC11_published_at())
                .customer_id(comment.getC12_customer_id())
                .is_highlight(comment.getC13_is_highlight())
                .is_sticky(comment.getC14_is_sticky())
                .is_closed(comment.getC15_is_closed())
                .created_at(comment.getC16_created_at())
                .created_by(comment.getC17_created_by())
                .updated_at(comment.getC18_updated_at())
                .updated_by(comment.getC19_updated_by())
                .deleted_at(comment.getC20_deleted_at())
                .deleted_by(comment.getC21_deleted_by())
                .build();
    }
}
