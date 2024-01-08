package com.example.niitiproduct.controllers.api;

import com.example.niitiproduct.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserDataController {
    @Autowired
    private UserService userService;

    @GetMapping("/users/all")
    public ResponseEntity<Object> index() {
        return userService.getAllUsers();
    }
}