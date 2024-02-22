package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="comments")
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

    public Comment(Integer id, Integer product_id, String type, String source, String author_name, String author_phone, String author_email, String author_address, String author_ip, String author_agent, String content, String status, String published_at, Integer customer_id, Integer is_highlight, Integer is_sticky, Integer is_closed, String created_at, String created_by, String updated_at, String updated_by, String deleted_at, String deleted_by) {
        this.id = id;
        this.product_id = product_id;
        this.type = type;
        this.source = source;
        this.author_name = author_name;
        this.author_phone = author_phone;
        this.author_email = author_email;
        this.author_address = author_address;
        this.author_ip = author_ip;
        this.author_agent = author_agent;
        this.content = content;
        this.status = status;
        this.published_at = published_at;
        this.customer_id = customer_id;
        this.is_highlight = is_highlight;
        this.is_sticky = is_sticky;
        this.is_closed = is_closed;
        this.created_at = created_at;
        this.created_by = created_by;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.deleted_at = deleted_at;
        this.deleted_by = deleted_by;
    }
}
