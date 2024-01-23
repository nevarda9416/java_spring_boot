package com.example.niitiproduct.mapper;

import com.example.niitiproduct.dto.UserDTO;
import com.example.niitiproduct.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDTO toDTO(User user) {
        return UserDTO.builder(
                ).id(user.getId())
                .name(user.getU00_name())
                .email(user.getU01_email())
                .email_verified_at(user.getU02_email_verified_at())
                .remember_token(user.getU04_remember_token())
                .created_at(user.getU05_created_at())
                .created_by(user.getU06_created_by())
                .updated_at(user.getU07_updated_at())
                .updated_by(user.getU08_updated_by())
                .deleted_at(user.getU09_deleted_at())
                .deleted_by(user.getU10_deleted_by())
                .build();
    }
}
