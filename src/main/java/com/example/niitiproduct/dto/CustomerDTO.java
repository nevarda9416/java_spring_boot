package com.example.niitiproduct.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {
    private Integer id;
    private String email;
    private String password;
    private Integer is_actived;
    private String first_name;
    private String last_name;
    private String birthday;
    private String gender;
    private String telephone;
    private String address;
    private String created_at;
    private String created_by;
    private String updated_at;
    private String updated_by;
    private String deleted_at;
    private String deleted_by;
}
