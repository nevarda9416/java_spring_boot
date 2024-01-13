package com.example.niitiproduct.services;

import com.example.niitiproduct.dto.UserDTO;
import com.example.niitiproduct.mapper.UserMapper;
import com.example.niitiproduct.models.User;
import com.example.niitiproduct.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    private UserRepository userRepository;
    public List<UserDTO> getAll() {
        return userRepository.findAll().stream().map(e->userMapper.toDTO(e)).toList();
    }

    public ResponseEntity<Object> getAllUsers() {
        List<User> userList = userRepository.findAll();
        if (userList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }
}
