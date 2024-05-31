package com.example.niitiproduct.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDTO {
    private Integer id;
    private String title;
    private String share_url;
    private String slug;
    private String excerpt;
    private String plain_text;
    private String content;
    private String author_name;
    private Integer user_id;
    private String status;
    private String published_at;
    private Integer is_comment;
    private Integer comment_count;
    private String post_type;
    private Integer category_id;
    private Integer is_highlight;
    private Integer show_on_homepage;
    private String meta_title;
    private String meta_keyword;
    private String meta_description;
    private String meta_image;
    private String created_at;
    private String created_by;
    private String updated_at;
    private String updated_by;
    private String deleted_at;
    private String deleted_by;
}
