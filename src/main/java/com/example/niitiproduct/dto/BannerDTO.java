package com.example.niitiproduct.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BannerDTO {
    private Integer id;
    private String name;
    private String description;
    private String thumbnail_url;
    private String banner_url;
    private Integer is_default;
    private Integer is_actived;
    private String created_at;
    private String created_by;
    private String updated_at;
    private String updated_by;
    private String deleted_at;
    private String deleted_by;
}
