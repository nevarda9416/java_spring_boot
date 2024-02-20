package com.example.niitiproduct.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDTO {
    private Integer id;
    private String name;
    private String image;
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

    public CategoryDTO(String number, String number1, String number2, String number3, String number4, String number5, String number6, String number7, String number8, String number9, String number10, String number11) {
    }
}



