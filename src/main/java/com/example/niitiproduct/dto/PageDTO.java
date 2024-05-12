package com.example.niitiproduct.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageDTO {
    private Integer id;
    private String title;
    private String slug;
    private String excerpt;
    private String plain_text;
    private String content;
    private String author_name;
    private Integer user_id;
    private String status;
    private Integer category_id;
    private String thumbnail_url;
    private String page_type;
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
