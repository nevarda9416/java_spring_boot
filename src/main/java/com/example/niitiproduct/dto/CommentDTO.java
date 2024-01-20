package com.example.niitiproduct.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDTO {
    private Integer id;
    private Integer product_id;
    private String type;
    private String source;
    private String author_name;
    private String author_phone;
    private String author_email;
    private String author_address;
    private String author_ip;
    private String author_agent;
    private String content;
    private String status;
    private String published_at;
    private Integer customer_id;
    private Integer is_highlight;
    private Integer is_sticky;
    private Integer is_closed;
    private String created_at;
    private String created_by;
    private String updated_at;
    private String updated_by;
    private String deleted_at;
    private String deleted_by;
}