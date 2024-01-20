package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="comments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer product_id;
    String type;
    String source;
    String author_name;
    String author_phone;
    String author_email;
    String author_address;
    String author_ip;
    String author_agent;
    String content;
    String status;
    String published_at;
    Integer customer_id;
    Integer is_highlight;
    Integer is_sticky;
    Integer is_closed;
    String created_at;
    String created_by;
    String updated_at;
    String updated_by;
    String deleted_at;
    String deleted_by;
}
