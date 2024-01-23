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
    Integer c00_product_id;
    @Column(name = "type")
    String c01_type;
    @Column(name = "source")
    String c02_source;
    @Column(name = "author_name")
    String c03_author_name;
    @Column(name = "author_phone")
    String c04_author_phone;
    @Column(name = "author_email")
    String c05_author_email;
    @Column(name = "author_address")
    String c06_author_address;
    @Column(name = "author_ip")
    String c07_author_ip;
    @Column(name = "author_agent")
    String c08_author_agent;
    @Column(name = "content")
    String c09_content;
    @Column(name = "status")
    String c10_status;
    @Column(name = "published_at")
    String c11_published_at;
    @Column(name = "customer_id")
    Integer c12_customer_id;
    @Column(name = "is_highlight")
    Integer c13_is_highlight;
    @Column(name = "is_sticky")
    Integer c14_is_sticky;
    @Column(name = "is_closed")
    Integer c15_is_closed;
    @Column(name = "created_at")
    String c16_created_at;
    @Column(name = "created_by")
    String c17_created_by;
    @Column(name = "updated_at")
    String c18_updated_at;
    @Column(name = "updated_by")
    String c19_updated_by;
    @Column(name = "deleted_at")
    String c20_deleted_at;
    @Column(name = "deleted_by")
    String c21_deleted_by;
}
