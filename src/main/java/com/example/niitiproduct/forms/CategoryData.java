package com.example.niitiproduct.forms;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryData {
    private Integer id;
    private String name;
    private MultipartFile image;
    private String summary;
    private String description;
    private Integer display_order;
    private Integer is_actived;
    private String created_at;
    private String created_by;
    private String updated_at;
    private String updated_by;
    private String deleted_at;
    private String deleted_by;
}



