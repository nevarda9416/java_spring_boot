package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="posts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "title")
    String title;
    @Column(name = "share_url")
    String share_url;
    @Column(name = "slug")
    String slug;
    @Column(name = "excerpt")
    String excerpt;
    @Column(name = "plain_text")
    String plain_text;
    @Column(name = "content")
    String content;
    @Column(name = "author_name")
    String author_name;
    @Column(name = "user_id")
    Integer user_id;
    @Column(name = "status")
    String status;
    @Column(name = "published_at")
    String published_at;
    @Column(name = "is_comment")
    Integer is_comment;
    @Column(name = "comment_count")
    Integer comment_count;
    @Column(name = "post_type")
    String post_type;
    @Column(name = "category_id")
    Integer category_id;
    @Column(name = "is_deleted")
    Integer is_deleted;
    @Column(name = "is_highlight")
    Integer is_highlight;
    @Column(name = "showon_homepage")
    Integer showon_homepage;
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
}
