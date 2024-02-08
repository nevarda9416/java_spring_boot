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
    @Column(name = "product_id")
    Integer product_id;
    @Column(name = "type")
    String type;
    @Column(name = "source")
    String source;
    @Column(name = "author_name")
    String author_name;
    @Column(name = "author_phone")
    String author_phone;
    @Column(name = "author_email")
    String author_email;
    @Column(name = "author_address")
    String author_address;
    @Column(name = "author_ip")
    String author_ip;
    @Column(name = "author_agent")
    String author_agent;
    @Column(name = "content")
    String content;
    @Column(name = "status")
    String status;
    @Column(name = "published_at")
    String published_at;
    @Column(name = "customer_id")
    Integer customer_id;
    @Column(name = "is_highlight")
    Integer is_highlight;
    @Column(name = "is_sticky")
    Integer is_sticky;
    @Column(name = "is_closed")
    Integer is_closed;
    @Column(name = "created_at")
    String created_at;
    @Column(name = "created_by")
    String created_by;
    @Column(name = "updated_at")
    String updated_at;
    @Column(name = "updated_by")
    String updated_by;
    @Column(name = "deleted_at")
    String deleted_at;
    @Column(name = "deleted_by")
    String deleted_by;
}
