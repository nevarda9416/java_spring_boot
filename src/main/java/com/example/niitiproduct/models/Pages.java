package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pages", indexes = {@Index(name = "index_page_id", columnList = "id")})
@NoArgsConstructor
@Getter
@Setter
public class Pages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "title")
    String title;
    @Column(name = "slug")
    String slug;
    @Column(name = "excerpt", columnDefinition = "TEXT")
    String excerpt;
    @Column(name = "plain_text", columnDefinition = "TEXT")
    String plain_text;
    @Column(name = "content", columnDefinition = "TEXT")
    String content;
    @Column(name = "author_name")
    String author_name;
    @Column(name = "user_id")
    Integer user_id;
    @Column(name = "status")
    String status;
    @Column(name = "category_id")
    Integer category_id;
    @Column(name = "thumbnail_url")
    String thumbnail_url;
    @Column(name = "page_type")
    String page_type;
    @Column(name = "meta_title")
    String meta_title;
    @Column(name = "meta_keyword")
    String meta_keyword;
    @Column(name = "meta_description")
    String meta_description;
    @Column(name = "meta_image")
    String meta_image;
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

    public Pages(Integer id, String title, String slug, String excerpt, String plain_text, String content, String author_name, Integer user_id, String status, Integer category_id, String thumbnail_url, String page_type, String meta_title, String meta_keyword, String meta_description, String meta_image, String created_at, String created_by, String updated_at, String updated_by, String deleted_at, String deleted_by) {
        this.id = id;
        this.title = title;
        this.slug = slug;
        this.excerpt = excerpt;
        this.plain_text = plain_text;
        this.content = content;
        this.author_name = author_name;
        this.user_id = user_id;
        this.status = status;
        this.category_id = category_id;
        this.thumbnail_url = thumbnail_url;
        this.page_type = page_type;
        this.meta_title = meta_title;
        this.meta_keyword = meta_keyword;
        this.meta_description = meta_description;
        this.meta_image = meta_image;
        this.created_at = created_at;
        this.created_by = created_by;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.deleted_at = deleted_at;
        this.deleted_by = deleted_by;
    }
}
