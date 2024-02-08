package com.example.niitiproduct.mapper;

import com.example.niitiproduct.dto.UserDTO;
import com.example.niitiproduct.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDTO toDTO(User user) {
        return UserDTO.builder(
                ).id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .email_verified_at(user.getEmail_verified_at())
                .remember_token(user.getRemember_token())
                .created_at(user.getCreated_at())
                .created_by(user.getCreated_by())
                .updated_at(user.getUpdated_at())
                .updated_by(user.getUpdated_by())
                .deleted_at(user.getDeleted_at())
                .deleted_by(user.getDeleted_by())
                .build();
    }
}
