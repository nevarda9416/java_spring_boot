package com.example.niitiproduct.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Integer id;
    private String name;
    private String email;
    private String email_verified_at;
    private String password;
    private String remember_token;
    private String created_at;
    private String created_by;
    private String updated_at;
    private String updated_by;
    private String deleted_at;
    private String deleted_by;
}
